package controllers;

import estruturasDados.Tabela;
import services.sort.QuickSortService;
import utils.InOutArquivos;

public class QuickSortBuscaBi extends SuperController{

	@Override
	public void iniciaApp() {
		super.iniciaApp("Quick");
	}

	@Override
	public void instanciaTabela(int nElem) {
		tabela = new Tabela(nElem);
	}

	@Override
	public void povoaTabelaPeloTXT(String fileName) {
		InOutArquivos.leitorTXTPessoaBanco("arquivos_in\\" + fileName, tabela);
	}
	
	@Override
	public void ordenaTabela() {
		Ordenacoes.SortService(tabela, new QuickSortService());
	}

	@Override
	public void geraTXTOrdenado(String fileName) {
		InOutArquivos.escritorTXTPessoaBanco(tabela, fileName);
	}

	@Override
	public void buscaEGeraTXTSaida(String fileName) {

		InOutArquivos.leitorTXTBusca(tabela, fileName);

		System.out.println("Fim da execucao");
	}
}
