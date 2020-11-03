package metodos;

import estruturasDados.Tabela;
import models.PessoaBanco;

public class QuickSort {

	public static void quicksort(Tabela tabela) {
		ordena(tabela,0 ,tabela.getNElem() - 1);
	}

	private static void  ordena (Tabela tabela, int esq, int dir){
		// esq e zero, então sempre a primeira pessoa
		//dir e ultimo elemento, então sempre a ultima pessoa
		
		int i = esq;
		int j = dir;

		PessoaBanco pivo = tabela.getVetor()[i+j/2];
		PessoaBanco temp;
		
		do {
			while (Compare.pessoa(tabela.getVetor()[i], pivo) > 0  ) {
				i++;
			}
			
			while (Compare.pessoa(tabela.getVetor()[j], pivo) < 0 ) {
				j--;
			}

			if (i <= j) {
				temp = tabela.getPessoa(i);
				tabela.getVetor()[i] = tabela.getVetor()[j] ;
				tabela.getVetor()[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		if (esq < j) {
			ordena(tabela,esq, j);
		}
		if (dir > i) {
			ordena(tabela, i, dir);
		}
	}

}
