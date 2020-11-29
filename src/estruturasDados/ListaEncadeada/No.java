package estruturasDados.ListaEncadeada;

import models.PessoaBanco;

public class No {
	private PessoaBanco info;
	private No prox;

	public No(PessoaBanco item) {
		this.info = item;
	}

	public PessoaBanco getInfo() {
		return info;
	}

	public void setInfo(PessoaBanco info) {
		this.info = info;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

}
