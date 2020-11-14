package estruturasDados;

import models.PessoaBanco;

public class Tabela extends SuperEstrutura{

	private PessoaBanco[] vetor;
	private int nElem;

	public Tabela(int tamanho) {
		this.vetor = new PessoaBanco[tamanho];
		this.nElem = 0;
	}

	public boolean addItem(PessoaBanco pessoa) {
		if (this.nElem == this.vetor.length) {
			return false;
		} else {
			this.vetor[this.nElem++] = pessoa;
			return true;
		}
	}
//
//	public boolean removeItem(int chave) {
//		int pos;
//		if (this.nElem == 0)
//			return false;
//		else {
//			pos = pesquisaSequencial(chave);
//			if (pos >= 0) {
//				this.nElem--;
//				this.vetor[pos] = this.vetor[this.nElem];
//				return true;
//			} else
//				return false;
//		}
//	}
//
//	public int pesquisaSequencial(int chave) {
//		int pos = this.nElem - 1;
//		while ((pos >= 0) && (this.vetor[pos].getChave() != chave)) {
//			pos--;
//		}
//		return pos;
//	}

	public int getNElem() {
		return this.nElem;
	}

	public PessoaBanco[] getVetor() {
		return this.vetor;
	}

	public PessoaBanco getPessoa(int index) {
		
		if(index > this.nElem || index < 0) {
			return null;
		}
		
		return this.vetor[index];

	}
	
}
