package controllers;

import estruturasDados.Tabela;
import metodos.HeapSort;
import metodos.QuickSort;

public class Sort {

	public static void heapSort(Tabela tabela) {
		HeapSort.heapSort(tabela);
	}
	
	public static void quicksort(Tabela tabela) {
		QuickSort.quicksort(tabela);
	}

}
