package services.sort;

import estruturasDados.Tabela;
import metodos.Compare;
import models.PessoaBanco;

public class QuickSortService implements GenericSortService {


	@Override
	public void sort(Tabela tabela) {
		quickSort(tabela.getVetor(), 0, tabela.getNElem() - 1);
	}

	public void quickSort(PessoaBanco[] vetor, int esquerda, int direita) {
		int esq = esquerda;
		int dir = direita;
		PessoaBanco pivo = vetor[(esq + dir) / 2];
		PessoaBanco troca;

		while (esq <= dir) {
			while (Compare.pessoa(vetor[esq], pivo) < 0) {
				esq = esq + 1;
			}
			while (Compare.pessoa(vetor[dir], pivo) > 0) {
				dir = dir - 1;
			}
			if (esq <= dir) {
				troca = vetor[esq];
				vetor[esq] = vetor[dir];
				vetor[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		if (dir > esquerda)
			quickSort(vetor, esquerda, dir);

		if (esq < direita)
			quickSort(vetor, esq, direita);

	}

}
