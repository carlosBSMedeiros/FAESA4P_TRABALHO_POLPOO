package controllers;

import estruturasDados.Tabela;
import models.PessoaBanco;

public class Buscas {

	public static PessoaBanco BuscaBinaria(Tabela tabela, PessoaBanco pessoaBusca) {
		int meio, esq, dir;
		esq = 0;
		dir = tabela.getNElem() - 1;
		while (esq <= dir) {
			meio = (esq + dir) / 2;
			if (pessoaBusca.getCpf().equals(tabela.getVetor()[meio].getCpf()))
				return tabela.getVetor()[meio];
			else {
				if (pessoaBusca.getCpf().compareTo(tabela.getVetor()[meio].getCpf()) < 0)
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return null;
	}
	
}
