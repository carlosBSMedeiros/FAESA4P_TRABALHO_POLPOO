package estruturasDados.ListaEncadeada;

import models.PessoaBanco;

public class Item {
	private PessoaBanco chave;

	public Item() {
	}

	public Item(PessoaBanco chave) {
		this.chave = chave;
	}

	public PessoaBanco getChave() {
		return chave;
	}

	public void setChave(PessoaBanco chave) {
		this.chave = chave;
	}

}
