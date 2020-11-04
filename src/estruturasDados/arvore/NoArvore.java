package estruturasDados.arvore;

import models.PessoaBanco;

public class NoArvore {
	private PessoaBanco info;
	private NoArvore dir, esq;

	public NoArvore(PessoaBanco info) {
		this.info = info;
	}

	public PessoaBanco getInfo() {
		return info;
	}

	public void setInfo(PessoaBanco info) {
		this.info = info;
	}

	public NoArvore getDir() {
		return dir;
	}

	public void setDir(NoArvore dir) {
		this.dir = dir;
	}

	public NoArvore getEsq() {
		return esq;
	}

	public void setEsq(NoArvore esq) {
		this.esq = esq;
	}

}
