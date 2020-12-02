package controllers;

import utils.InOutInterface;

public class Main {

	public void main(String metodo, String tamanho) {
		/*
		 * a interface usa essa classe para encaminha o fluxo de execução para rodar todos os metodos ou se rodara apenas um especifico 
		 * */
		
		switch (metodo) {
		case "Quick":
			QuickSortController buscaBi = new QuickSortController();
			if (tamanho.equals("Todos")) {
				buscaBi.iniciaApp();
			} else {
				buscaBi.iniciaApp(tamanho);
			}

			break;
		case "Heap":
			HeapSortController hpbb = new HeapSortController();
			if (tamanho.equals("Todos")) {
				hpbb.iniciaApp();
			} else {
				hpbb.iniciaApp(tamanho);
			}

			break;
		case "Todos":
			if (tamanho.equals("Todos")) {
				todosMetodosTamanhos();
			} 

			break;
		case "Hashing":
			HashingController hashController = new HashingController();
			if (tamanho.equals("Todos")) {
				hashController.iniciaApp();
			} else {
				hashController.iniciaApp(tamanho);
			}
			
			break;

		case "ABB":
			ArvoreABBController abbController = new ArvoreABBController();
			if (tamanho.equals("Todos")) {
				abbController.iniciaApp();
			} else {
				abbController.iniciaApp(tamanho);
			}
			break;

		case "AVL":
			ArvoreAVLController arvoreAVLController = new ArvoreAVLController();
			if (tamanho.equals("Todos")) {
				arvoreAVLController.iniciaApp();
			} else {
				arvoreAVLController.iniciaApp(tamanho);
			}

			break;
		default:
			InOutInterface.outputError("Opcao nao disponivel");
			break;
		}

	}

	public void todosMetodosTamanhos() {
		//metodo que rodará todos os metodos em todos os tamanhos

		HeapSortController hpbb = new HeapSortController();
		hpbb.iniciaApp();

		QuickSortController buscaBi = new QuickSortController();
		buscaBi.iniciaApp();

		ArvoreABBController abbController = new ArvoreABBController();
		abbController.iniciaApp();

		ArvoreAVLController arvoreAVLController = new ArvoreAVLController();
		arvoreAVLController.iniciaApp();
		
		HashingController hashingController = new HashingController();
		hashingController.iniciaApp();
	}
	
	
	
	public void todosMetodosUnicoTamanho(String tamanho) {
		//metodo que rodará todos os metodos e um unico tamanho
		HeapSortController hpbb = new HeapSortController();
		hpbb.iniciaApp(tamanho);

		QuickSortController buscaBi = new QuickSortController();
		buscaBi.iniciaApp(tamanho);

		ArvoreABBController abbController = new ArvoreABBController();
		abbController.iniciaApp(tamanho);

		ArvoreAVLController arvoreAVLController = new ArvoreAVLController();
		arvoreAVLController.iniciaApp(tamanho);
		
		HashingController hashingController = new HashingController();
		hashingController.iniciaApp(tamanho);

	}

}
