package controllers;

import java.io.IOException;

import estruturasDados.FilaPessoa;
import estruturasDados.Tabela;
import models.PessoaBanco;
import utils.Cronometro;
import utils.InOutArquivos;

public class Main {

	static Tabela tabela;

	public static void main(String[] args) {

		iniciaApp();
		
		System.out.println("Tabela preenchida!");
	
	}
	
	public static void iniciaApp() {
		Cronometro.iniciaCronometro();
		instanciaTabela(10);
		povoaTabelaPeloTXT();
		ordenaTabela();
		geraTXTOrdenado();
		buscaEGeraTXTSaida();
		Cronometro.paraCronometro();

	}
	
	private static void instanciaTabela(int nElem) {
		tabela = new Tabela(nElem);
	}
	
	private static void povoaTabelaPeloTXT() {
		try {
			InOutArquivos.leitorTXTPessoaBanco("C:\\el\\Fabio.Helmer\\treinamento\\javaFaesa\\trabalho\\FAESA4P_TRABALHO_POLPOO\\archives\\inAlea500.txt", tabela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ordenaTabela() {
		//refatorar metodo com enuns para os algoritmos de ordenacao, e switch case
		
		//Sort.heapSort(tabela);
		Sort.quicksort(tabela);
	}
	
	private static void geraTXTOrdenado() {
		try {
			InOutArquivos.escritorTXTPessoaBanco(tabela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void buscaEGeraTXTSaida() {
		FilaPessoa result = Buscas.BuscaBinaria(tabela, "12399999999");
		
		while(result.getSize() != 0) {
			PessoaBanco aux = result.desenfileirar();
			System.out.println(aux.getCpf() + " " + aux.getAgencia() + " " + aux.getConta());
		}
	}

}
