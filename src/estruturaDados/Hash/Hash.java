package estruturaDados.Hash;

import controllers.SuperController;
import estruturasDados.SuperEstrutura;
import estruturasDados.Tabela;
import models.PessoaBanco;

public class Hash extends SuperEstrutura {

	private NoHash[] hashEncadeado;

	public Hash(int tamanho) {
		hashEncadeado = new NoHash[getTamanhoVetor(tamanho)];
	}

	public void insere(PessoaBanco pessoa) {
		int index = hashing(pessoa.getCpf());
		NoHash noHash = this.hashEncadeado[index];
		if (noHash != null) {
			noHash.getInfos().add(pessoa);
		} else {
			noHash = new NoHash();
			noHash.getInfos().add(pessoa);
			this.hashEncadeado[index] = noHash;
		}
	}

	// Pega o numero da posição do vetor que vai o novo elemento
	public int hashing(String chave) {
		char carac;
		int i, soma = 0;
		for (i = 0; i < chave.length(); i++) {
			carac = chave.charAt(i);
			soma += Character.getNumericValue(carac);
		}
		return soma;
	}

	public int getTamanhoVetor(int num) {
		int M;
		M = (int) (1.1 * num);
		if (this.isPrime(M)) {
			return M;
		} else {
			return this.getPrime(M);
		}
	}

	public static boolean isPrime(int n) { // Function to check if a number is cousin.
		int c = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				c++;
		}
		if (c == 2)// Prime no.has 2 factors-1 and number itself.
			return true;
		else
			return false;
	}

	public int getPrime(int num) {
		int diff1 = 0, diff2 = 0;
		int num1 = 0, num2 = 0;
		for (int i = num;; i++) { // No end limit as when prime will be found we will break the loop.
			if (isPrime(i)) {
				diff1 = i - num;
				num1 = i;
				break;
			}
		}

		for (int i = num;; i--) { // No end limit as when prime will be found we will break the loop.
			if (isPrime(i)) {
				diff2 = num - i;
				num2 = i;
				break;
			}
		}

		if (diff1 < diff2) // Nearest Prime number will have least difference from given number.
			return num1;
		else
			return num2;
	}

	@Override
	public String toString() {
		String msg = "";

		for (int i = 0; i < hashEncadeado.length; i++) {
			if (hashEncadeado[i] != null) {
				msg += hashEncadeado[i].toString() + "\n";
			}
		}

		return msg;
	}

}
