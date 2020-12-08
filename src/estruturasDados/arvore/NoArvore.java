package estruturasDados.arvore;

import java.util.LinkedList;

import models.PessoaBanco;

public class NoArvore {
	private PessoaBanco info;
	private NoArvore dir, esq;
	private LinkedList<PessoaBanco> pessoasBanco;

	public NoArvore(PessoaBanco info) {
		this.info = info;
		this.pessoasBanco = new LinkedList<PessoaBanco>();
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

	public LinkedList<PessoaBanco> getPessoaBancos() {
		return pessoasBanco;
	}

	public void setPessoaBancoLinked(PessoaBanco pessoaBanco) {
		this.pessoasBanco.add(pessoaBanco);
	}
	

}
