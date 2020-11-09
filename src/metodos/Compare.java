package metodos;

import models.PessoaBanco;

public class Compare {
	
	public static byte pessoa(PessoaBanco pessoa1, PessoaBanco pessoa02) {

		int compareCpf = pessoa1.getCpf().compareTo(pessoa02.getCpf());

		if (compareCpf < 0) {
			return -1;
		} else if (compareCpf > 0) {
			return 1;
		} else {
			return pessoaAgencia(pessoa1, pessoa02);
		}
	}

	private static byte pessoaAgencia(PessoaBanco pessoa1, PessoaBanco pessoa02) {

		int compareAgencia = pessoa1.getAgencia().compareTo(pessoa02.getAgencia());

		if (compareAgencia < 0) {
			return -1;
		} else if (compareAgencia > 0) {
			return 1;
		} else {
			return pessoaConta(pessoa1, pessoa02);
		}
	}

	private static byte pessoaConta(PessoaBanco pessoa1, PessoaBanco pessoa02) {
		int comparaConta = pessoa1.getConta().compareTo(pessoa02.getConta());

		if (comparaConta < 0) {
			return -1;
		} else if (comparaConta > 0) {
			return 1;
		} else {
			return 0;
		}

	}
}
