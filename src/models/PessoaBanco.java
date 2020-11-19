package models;

public class PessoaBanco {

	
	//cpf;nome;ag�ncia;conta;saldo
	
	private String cpf;
	private String nome;
	private String agencia;
	private String conta;
	private String saldo;

	public PessoaBanco() {
		super();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	
	public String getTipoConta() {
		switch (this.conta.substring(0, 3)) {

		case "001":
			return " Conta Comum: ";
		case "002":
			return " Conta Especial: ";
		case "010":
			return " Conta Poupança: ";
		default:
			return " Conta não especificada: ";
		}
	}
	
}
