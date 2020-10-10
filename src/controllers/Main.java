package controllers;

import java.io.IOException;

import estruturasDados.Tabela;
import utils.InOutArquivos;

public class Main {

	static Tabela tabela;

	public static void main(String[] args) {

		iniciaApp();
		
		System.out.println("Tabela preenchida!");
	
	}
	
	public static void iniciaApp() {
		
		instanciaTabela(500);
		povoaTabelaPeloTXT();
		ordenaTabela();
		geraTXTOrdenado();
		buscaEGeraTXTSaida();
	}
	
	private static void instanciaTabela(int nElem) {
		tabela = new Tabela(nElem);
	}
	
	private static void povoaTabelaPeloTXT() {
		try {
			InOutArquivos.leitorTXTPessoaBanco("D:\\WorkSpaces\\TrabalhoPOLPOO\\ProjetoLOLPOO\\archives\\inAlea500.txt", tabela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ordenaTabela() {
		//refatorar metodo com enuns para os algoritmos de ordenacao, e switch case
		
		Sort.HeapSort(tabela);

	}
	
	private static void geraTXTOrdenado() {
		try {
			InOutArquivos.escritorTXTPessoaBanco(tabela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void buscaEGeraTXTSaida() {
		
	}

}
