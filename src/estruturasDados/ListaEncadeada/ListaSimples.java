package estruturasDados.ListaEncadeada;

import estruturasDados.SuperEstrutura;
import metodos.Compare;
import models.PessoaBanco;

public class ListaSimples extends SuperEstrutura{
	private No prim;
	private No ult;
	private int quantNos;

	public ListaSimples() {
		this.quantNos = 0;
	}

	public No getPrim() {
		return prim;
	}

	public void setPrim(No prim) {
		this.prim = prim;
	}

	public No getUlt() {
		return ult;
	}

	public void setUlt(No ult) {
		this.ult = ult;
	}

	public int getQuantNos() {
		return quantNos;
	}

	public boolean isVazia() {
		return (this.prim == null);
	}

	public void setQuantNos(int quantNos) {
		this.quantNos = quantNos;
	}

	// aidiona na primeira posicao da lista
	public void addNoComeco(PessoaBanco PessoaBanco) {
		No novoNo = new No(PessoaBanco);
		if (this.quantNos == 0) {
			this.prim = novoNo;
		} else {
			novoNo.setProx(this.prim);
			this.prim = novoNo;
		}
		this.quantNos++;
	}

	// adiciona PessoaBanco na ultimo posicao
	public void add(PessoaBanco PessoaBanco) {
		No novoNo = new No(PessoaBanco);
		if (this.isVazia()) {
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}
	// adicona valorios itens a lista
	public void add(PessoaBanco... PessoaBancos) {
		for (PessoaBanco PessoaBanco : PessoaBancos) {
			add(PessoaBanco);
		}
	}

	// adiciona no k-esima posicao
	public boolean addKesimo(int k, PessoaBanco elem) {

		if (this.prim == null || this.quantNos < k) {
			return false;
		} else {
			No novoNo = new No(elem);
			this.quantNos++;
			if (k == 1) {
				novoNo.setProx(this.prim);
				this.prim = novoNo;
			} else {
				No atual = this.prim;
				for (int i = 0; i < k; i++) {
					atual = atual.getProx();
				}
				novoNo.setProx(atual.getProx());
				atual.setProx(novoNo);
			}
			return true;
		}

	}

	// pesquisa no pela posicao
	public No pes(int index) {
		No atual = this.prim;
		if (isVazia()) {
			return atual;
		} else {
			if (!(index > this.quantNos)) {
				for (int i = 1; i < index; i++) {
					atual = atual.getProx();
				}
			}
		}
		return atual;
	}

	// pesquisa no pela informacao
	public No pesInfo(PessoaBanco k) {
		No atual = this.prim;
		if (!isVazia()) {
			while ((atual != null) && (Compare.pessoa(atual.getInfo(), k) != 0)) {
				atual = atual.getProx();
			}
		}
		return atual;
	}



	// remove da k-esima posicao
	public boolean removeKesima(PessoaBanco k) {
		No atual = this.prim;
		No ant = null;
		if (isVazia()) {
			return false;
		} else {
			while ((atual != null) &&  (Compare.pessoa(atual.getInfo(), k) != 0)) {
				ant = atual;
				atual = atual.getProx();
			}
			if (atual == null) {
				return false;
			} else {
				if (atual == this.prim) {
					if (this.prim == this.ult) {
						this.ult = null;
					}
					this.prim = this.prim.getProx();
				} else {
					if (atual == this.ult) {
						this.ult = ant;
					}
					ant.setProx(atual.getProx());
				}
				this.quantNos--;
				return true;

			}
		}
	}

	// concatena a lista no final
	public boolean concListas(ListaSimples listaSimples) {
		if (listaSimples.isVazia()) {
			return false;
		}
		if (isVazia()) {
			this.prim = listaSimples.getPrim();
			this.ult = listaSimples.getUlt();
			this.quantNos = listaSimples.getQuantNos();
			return true;
		} else {
			this.ult.setProx(listaSimples.getPrim());
			this.quantNos += listaSimples.getQuantNos();
			this.ult = listaSimples.getUlt();

		}
		listaSimples.setPrim(null);
		listaSimples.setUlt(null);
		listaSimples.setQuantNos(0);
		return true;
	}


	public ListaSimples inverteLista() {
		ListaSimples listaSimples = new ListaSimples();
		No atual = this.prim;

		for (int i = 0; i < this.quantNos; i++) {
			listaSimples.addNoComeco(atual.getInfo());
			atual = atual.getProx();
		}
		return listaSimples;

	}

	// mostra o conteudo da lista
	@Override
	public String toString() {
		String msg = "";
		No atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().toString() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}

}
