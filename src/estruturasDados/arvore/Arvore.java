package estruturasDados.arvore;
import java.util.ArrayList;

import estruturasDados.SuperEstrutura;
import metodos.Compare;
import models.PessoaBanco;

public class Arvore extends SuperEstrutura {
	
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

//	public boolean insere(PessoaBanco pessoa) {
//		boolean existe;
//		
//		existe = this.pesquisa(pessoa);
//		if (existe)
//			return false;
//		else {
//			this.raiz = this.insere(pessoa, this.raiz);
//			return true;
//		}
//	}
//
//	private NoArvore insere(PessoaBanco pessoa, NoArvore no) {
//		if (no == null) {
//			NoArvore novaPessoa = new NoArvore(pessoa);
//			return novaPessoa;
//		} else {
//			if (Compare.pessoa(pessoa, no.getInfo()) < 0) {
//				no.setEsq(this.insere(pessoa, no.getEsq()));
//				return no;
//			} else {
//				no.setDir(this.insere(pessoa, no.getDir()));
//				return no;
//			}
//		}
//	}
		
}
