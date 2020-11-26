package estruturasDados.arvore;

import java.util.ArrayList;

import estruturasDados.FilaPessoa;
import estruturasDados.SuperEstrutura;
import metodos.Compare;
import models.PessoaBanco;
import services.find.ArvoreFindService;

public class ArvoreABB extends SuperEstrutura {

	private NoArvore raiz;

	public ArvoreABB() {

	}

	public ArvoreABB(NoArvore raiz) {
		this.raiz = raiz;
	}

	public NoArvore getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore raiz) {
		this.raiz = raiz;
	}

	public boolean insere(PessoaBanco pessoa, ArvoreABB arvore) {
		FilaPessoa existe;

		ArvoreFindService service = new ArvoreFindService();

		existe = service.find(arvore, pessoa.getCpf());
		if (existe.getSize() > 0)
			return false;
		else {
			arvore.setRaiz(this.insere(pessoa, arvore.getRaiz()));
			return true;
		}
	}

	private NoArvore insere(PessoaBanco pessoa, NoArvore no) {
		if (no == null) {
			NoArvore novaPessoa = new NoArvore(pessoa);
			return novaPessoa;
		} else {
			if (Compare.pessoa(pessoa, no.getInfo()) < 0) {
				no.setEsq(this.insere(pessoa, no.getEsq()));
				return no;
			} else {
				no.setDir(this.insere(pessoa, no.getDir()));
				return no;
			}
		}
	}

	public ArrayList<PessoaBanco> InOrdem() {
		ArrayList<PessoaBanco> lista = new ArrayList<PessoaBanco>();
		return (this.FazCamInOrdem(this.raiz, lista));
	}

	private ArrayList<PessoaBanco> FazCamInOrdem(NoArvore noArvore, ArrayList<PessoaBanco> lista) {
		if (noArvore != null) {
			lista = this.FazCamInOrdem(noArvore.getEsq(), lista);
			lista.add(noArvore.getInfo());
			lista = this.FazCamInOrdem(noArvore.getDir(), lista);
		}
		return lista;
	}

}
