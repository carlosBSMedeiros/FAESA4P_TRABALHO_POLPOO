package estruturasDados.arvore;

import models.PessoaBanco;

public class NoArvoreABB {
	private PessoaBanco info;
	private NoArvoreABB dir, esq;

	public NoArvoreABB(PessoaBanco info) {
		this.info = info;
	}

	public PessoaBanco getInfo() {
		return info;
	}

	public void setInfo(PessoaBanco info) {
		this.info = info;
	}

	public NoArvoreABB getDir() {
		return dir;
	}

	public void setDir(NoArvoreABB dir) {
		this.dir = dir;
	}

	public NoArvoreABB getEsq() {
		return esq;
	}

	public void setEsq(NoArvoreABB esq) {
		this.esq = esq;
	}

}
