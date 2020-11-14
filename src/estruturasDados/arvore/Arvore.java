package estruturasDados.arvore;
import java.util.ArrayList;

import metodos.Compare;
import models.PessoaBanco;

public class Arvore {
	
	private NoArvore raiz;
	
	public Arvore() {
		
	}

	public Arvore(NoArvore raiz) {
		this.raiz = raiz;
	}
	
	public NoArvore getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvore raiz) {
		this.raiz = raiz;
	}

	public boolean insere(PessoaBanco pessoa) {
		boolean existe;
		
		existe = this.pesquisa(pessoa);
		if (existe)
			return false;
		else {
			this.raiz = this.insere(pessoa, this.raiz);
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
	
	public boolean pesquisa(PessoaBanco pessoa) {
		NoArvore no = this.pesquisa(pessoa, this.raiz);
		
		if (no != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private NoArvore pesquisa(PessoaBanco pessoa, NoArvore no) {
		NoArvore noTemp = no;
		
		if (noTemp != null) {
			if (Compare.pessoa(pessoa, no.getInfo()) < 0) {
				noTemp = this.pesquisa(pessoa, noTemp.getEsq());
			} else {
				if (Compare.pessoa(pessoa, noTemp.getInfo()) > 0) {
					noTemp = this.pesquisa(pessoa, noTemp.getDir());
				}
			}
		}
		return noTemp;
	}
	
	public ArrayList<PessoaBanco> camCentral(ArrayList<PessoaBanco> vetOrdenado) {
		return (this.fazCamCentral(this.raiz, vetOrdenado));
	}
	
	private ArrayList<PessoaBanco> fazCamCentral(NoArvore arv, ArrayList<PessoaBanco> vetOrdenado) {
		if (arv != null) {
			vetOrdenado = this.fazCamCentral(arv.getEsq(), vetOrdenado);
			vetOrdenado.add(arv.getInfo());
			vetOrdenado = this.fazCamCentral(arv.getDir(), vetOrdenado);
		}
		return vetOrdenado;
	}
	
	public Arvore arvoreBalanceada(ArrayList<PessoaBanco> vetOrdenado) {
		Arvore temp = new Arvore();
		this.balancear(vetOrdenado, temp, 0, vetOrdenado.size() - 1);
		return temp;
	}
	
	private void balancear(ArrayList<PessoaBanco> vet, Arvore temp, int inic, int fim) {
		int meio;
		if (fim >= inic) {
			meio = (inic+fim)/2;
			temp.insere(vet.get(meio));
			this.balancear(vet, temp, inic, meio - 1);
			this.balancear(vet, temp, meio + 1, fim);
		}
	}
}
