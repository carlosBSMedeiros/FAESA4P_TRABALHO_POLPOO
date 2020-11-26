package controllers;

import java.util.ArrayList;
import java.util.List;

import estruturasDados.Tabela;

import utils.InOutInterface;


public class Main {

	public List<Double> main(String metodo, String tamanho) {
		List<Double> result =  new ArrayList<Double>();
		
		String sistema = System.getProperty("os.name");
		System.out.println(sistema);
		switch (metodo) {
		case "Quick":
			QuickSortBuscaBi buscaBi = new QuickSortBuscaBi();
			if (tamanho.equals("Todos")) {
				buscaBi.iniciaApp();
			} else {
				buscaBi.iniciaApp(tamanho);
			}
			
			break;
		case "Heap":
			HeapSortBuscaBi hpbb = new HeapSortBuscaBi();
			if (tamanho.equals("Todos")) {
				hpbb.iniciaApp();
			} else {
				hpbb.iniciaApp(tamanho);
			}

			break;
		case "Todos":
			if (tamanho.equals("Todos")) {
				todosMetodosTamanhos();
			} else {
				todosMetodosUnicoTamanho(tamanho);
			}

			break;
		case "Hashing":
			
			break;
		
		case "ABB":
			
			break;
			
		case "AVL":
			
			break;
		default:
			InOutInterface.outputError("Opção não disponivel");
			break;
		}
		return result;
	}

	public void todosMetodosTamanhos() {

		HeapSortBuscaBi hpbb = new HeapSortBuscaBi();
		hpbb.iniciaApp();

		QuickSortBuscaBi buscaBi = new QuickSortBuscaBi();
		buscaBi.iniciaApp();

	}

	public void todosMetodosUnicoTamanho(String tamanho) {

		QuickSortBuscaBi buscaBi = new QuickSortBuscaBi();
		buscaBi.iniciaApp(tamanho);

		HeapSortBuscaBi hpbb = new HeapSortBuscaBi();
		hpbb.iniciaApp(tamanho);


	}
}
