package controllers;

import estruturasDados.Tabela;

public class Main {

	static Tabela tabela;

	public static void main(String[] args) {

		HeapSortBuscaBi hpbb = new HeapSortBuscaBi();		
		hpbb.iniciaApp();
		
		QuickSortBuscaBi buscaBi = new QuickSortBuscaBi();
		buscaBi.iniciaApp();
		
		 
	}

}
