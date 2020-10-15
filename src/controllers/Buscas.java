package controllers;


import java.util.ArrayList;
import java.util.List;

import estruturasDados.FilaPessoa;
import estruturasDados.Tabela;
import models.PessoaBanco;

public class Buscas {

	public static FilaPessoa BuscaBinaria(Tabela tabela, String cpfBusca) {
		FilaPessoa result =  new FilaPessoa();
		
		int meio, esq, dir;
		esq = 0;
		dir = tabela.getNElem() - 1;
		while (esq <= dir) {
			meio = (esq + dir) / 2;
			if (cpfBusca.equals(tabela.getVetor()[meio].getCpf())) {
				verificaProximos(tabela, result, meio);
				return result;
			}
			else {
				if (cpfBusca.compareTo(tabela.getVetor()[meio].getCpf()) < 0)
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return null;
	}
	
	private static void verificaProximos(Tabela tabela, FilaPessoa result, int meio) {
		
		verificaEsquerda(tabela, result, meio);
		result.enfileirar(tabela.getVetor()[meio]);
		verificaDireita(tabela, result, meio);
		
//		while(tabela.getVetor()[dir] != null && tabela.getVetor()[meio].getCpf().compareTo(tabela.getVetor()[dir].getCpf()) == 0) {
//			result.add(tabela.getVetor()[dir]);
//			dir++;
//		}
//		
//		while(tabela.getVetor()[meio].getCpf().compareTo(tabela.getVetor()[esq].getCpf()) == 0) {
//			result.add(tabela.getVetor()[esq]);
//			esq--;
//		}
//		
	}

	private static boolean verificaEsquerda(Tabela tabela, FilaPessoa result, int meio) {
		
		int esq = meio - 1;
		
		if (tabela.getVetor()[esq] != null && tabela.getVetor()[meio].getCpf().compareTo(tabela.getVetor()[esq].getCpf()) == 0) {
			verificaEsquerda(tabela, result, esq);
			result.enfileirar(tabela.getVetor()[esq]);
			return true;
		} 
		
		return false;
	}
	

	private static boolean verificaDireita(Tabela tabela, FilaPessoa result, int meio) {
		
		int dir = meio + 1;
		
		if (tabela.getVetor()[dir] != null && tabela.getVetor()[meio].getCpf().compareTo(tabela.getVetor()[dir].getCpf()) == 0) {
			result.enfileirar(tabela.getVetor()[dir]);
			verificaDireita(tabela, result, dir);
			return true;
		} 
		
		return false;
	}
	
}
