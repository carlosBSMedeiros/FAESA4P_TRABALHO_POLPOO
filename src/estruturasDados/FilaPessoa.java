package estruturasDados;

import java.util.LinkedList;

import models.PessoaBanco;

public class FilaPessoa {
	private LinkedList<PessoaBanco> fila;

	public FilaPessoa() {
		this.fila = new LinkedList<>();
	}
	
	public boolean eVazia() {
		return this.fila.isEmpty();
	}
	
	public boolean enfileirar(PessoaBanco elem) {
		this.fila.add(elem);
		return true;
	}
	
	public PessoaBanco desenfileirar() {
		if(this.eVazia()) {
			return null;
		}
		return this.fila.removeFirst();
	}
	
	public PessoaBanco getPrimeiro() {
		return this.fila.getFirst();
	}
	
	public int getSize() {
		return this.fila.size();
	}
}
