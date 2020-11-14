package services.sort;

import estruturasDados.Tabela;
import metodos.Compare;
import models.PessoaBanco;

public class HeapSortService implements GenericSortService{
	
	public void sort(Tabela tabela) {

		int dir = tabela.getNElem() - 1;
		int esq = (dir - 1) / 2;
		PessoaBanco temp;
		while (esq >= 0) {
			refazHeap(esq, tabela.getNElem() - 1, tabela);
			esq--;
		}
		while (dir > 0) {
			temp = tabela.getVetor()[0];
			tabela.getVetor()[0] = tabela.getVetor()[dir];
			tabela.getVetor()[dir] = temp;
			dir--;
			refazHeap(0, dir, tabela);
		}
	}

	private void refazHeap(int esq, int dir, Tabela tabela) {
		int i = esq;
		int mF = 2 * i + 1; // maior filho
		PessoaBanco raiz = tabela.getVetor()[i];
		boolean heap = false;
		while ((mF <= dir) && (!heap)) {
			if (mF < dir) {
				if (Compare.pessoa(tabela.getVetor()[mF], tabela.getVetor()[mF + 1]) < 0) {
					mF++;
				}
			}
			
		 if (Compare.pessoa(raiz,tabela.getVetor()[mF]) < 0) {
				tabela.getVetor()[i] = tabela.getVetor()[mF];
				i = mF;
				mF = 2 * i + 1;
			} else
				heap = true;
		}
		tabela.getVetor()[i] = raiz;
	}
}
