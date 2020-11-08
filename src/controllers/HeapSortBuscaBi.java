package controllers;

import java.io.IOException;

import estruturasDados.FilaPessoa;
import estruturasDados.Tabela;
import services.find.BuscaBinFindService;
import services.sort.HeapSortService;
import utils.Cronometro;
import utils.InOutArquivos;

public class HeapSortBuscaBi implements InterfaceControllers{
	
	static Tabela tabela;
	
	public void iniciaApp() {
		Cronometro.iniciaCronometro();
		instanciaTabela(500);
		povoaTabelaPeloTXT();
		ordenaTabela();
		geraTXTOrdenado();
		buscaEGeraTXTSaida();
		Cronometro.paraCronometro();
	}
	
	public void instanciaTabela(int nElem) {
		tabela = new Tabela(nElem);
	}
	
	public void povoaTabelaPeloTXT() {
		try {
			InOutArquivos.leitorTXTPessoaBanco("D:\\WorkSpaces\\TrabalhoPOLPOO\\FAESA4P_TRABALHO_POLPOO\\archives\\inAlea500.txt", tabela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ordenaTabela() {
		
		Sort.SortService(tabela, new HeapSortService());

	}
	
	public void geraTXTOrdenado() {
		try {
			InOutArquivos.escritorTXTPessoaBanco(tabela);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void buscaEGeraTXTSaida() {
		
		
		FilaPessoa result = Buscas.FindService(tabela, "12399999999", new BuscaBinFindService());
		
	
	}
	
	
	
}
