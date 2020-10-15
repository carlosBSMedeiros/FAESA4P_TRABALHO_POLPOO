package metodos;

import estruturasDados.Tabela;
import models.PessoaBanco;

public class QuickSort {

	public static void quicksort(Tabela tabela) {
		ordena(tabela);
	}

	private static void ordena (Tabela tabela){
		// esq e zero, então sempre a primeira pessoa
		//dir e ultimo elemento, então sempre a ultima pessoa
		
		int nElem =  tabela.getNElem() - 1;
		
		PessoaBanco pivo;
		PessoaBanco esq = tabela.getPessoa(0);
		PessoaBanco dir= tabela.getPessoa(nElem);
		PessoaBanco temp;

		pivo = tabela.getPessoa(nElem/2);
		
//		do {
//			while (this.vetor[i].getChave() < pivo) {
//				i++;
//			}
//			
//			while (this.vetor[j].getChave() > pivo) {
//				j--;
//			}
//
//			if (i <= j) {
//				temp = this.vetor[i];
//				this.vetor[i] = this.vetor[j];
//				this.vetor[j] = temp;
//				i++;
//				j--;
//			}
//		} while (i <= j);
//		if (esq < j) {
//			ordena(esq, j);
//		}
//		if (dir > i) {
//			ordena(i, dir);
//		}
	}

}
