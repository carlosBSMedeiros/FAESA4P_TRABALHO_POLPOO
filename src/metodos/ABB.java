package metodos;
import estruturasDados.arvore.*;
import models.PessoaBanco;

public class ABB {
	
	public boolean pesquisa(PessoaBanco pessoa, ArvoreABB arvore) {
		NoArvoreABB no;
		no = this.pesquisa(pessoa, arvore.getRaiz());
		if (no != null)
			return true;
		else
			return false;
	}

	private NoArvoreABB pesquisa(PessoaBanco pessoa, NoArvoreABB no) {
		if (no != null) {
			if (Compare.pessoa(pessoa, no.getInfo()) < 0)
				no = this.pesquisa(pessoa, no.getEsq());
			else {
				if (Compare.pessoa(pessoa, no.getInfo()) > 0)
					no = this.pesquisa(pessoa, no.getDir());
			}
		}
		return no;
	}

//	public boolean insere(Item elem) {
//		boolean existe;
//		existe = this.pesquisa(elem.getChave());
//		if (existe)
//			return false;
//		else {
//			this.raiz = this.insere(elem, this.raiz);
//			return true;
//		}
//	}
//
//	private NoArvore insere(Item elem, NoArvore no) {
//		NoArvore novo;
//		if (no == null) {
//			novo = new NoArvore(elem);
//			return novo;
//		} else {
//			if (elem.getChave() < no.getInfo().getChave()) {
//				no.setEsq(this.insere(elem, no.getEsq()));
//				return no;
//			} else {
//				no.setDir(this.insere(elem, no.getDir()));
//				return no;
//			}
//		}
//	}
}
