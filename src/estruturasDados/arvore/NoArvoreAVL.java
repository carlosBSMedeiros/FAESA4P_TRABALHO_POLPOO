package estruturasDados.arvore;

import estruturasDados.Item;
import models.PessoaBanco;

public class NoArvoreAVL extends NoArvore {

	private byte fatorBalanceamento;

	public NoArvoreAVL(PessoaBanco info) {
		super(info);
		this.fatorBalanceamento = 0;
	}

	public byte getFatorBalanceamento() {
		return this.fatorBalanceamento;
	}

	public void setFatorBalanceamento(byte fatorBalanceamento) {
		this.fatorBalanceamento = fatorBalanceamento;
	}
	

}
