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
		this.raiz = null;
	}

	public NoArvore getRaiz() {
		return raiz;
	}

	public void insereRaiz(PessoaBanco pessoaBanco) {
		this.raiz = this.insere(pessoaBanco, this.raiz);
	}

	private NoArvore insere(PessoaBanco pessoaBanco, NoArvore no) {
		if (no == null) {
			NoArvore novo = new NoArvore(pessoaBanco);
			return novo;
		} else {
			
			if (Compare.pessoa(pessoaBanco, no.getInfo()) < 0) {
				no.setEsq(this.insere(pessoaBanco, no.getEsq()));
				return no;
			} else {
				no.setDir(this.insere(pessoaBanco, no.getDir()));
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
