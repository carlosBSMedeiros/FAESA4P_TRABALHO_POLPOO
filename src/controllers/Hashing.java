package controllers;

import estruturasDados.Tabela;
import services.sort.HeapSortService;
import utils.InOutArquivos;

public class Hashing extends SuperController {
	
	@Override
	public void iniciaApp() {
		super.iniciaApp("Hashing");
	}
	
	@Override
	public void iniciaApp(String tamanho) {
		super.iniciaApp("Hashing", tamanho);
	}

	@Override
	public void instanciaEstrutura(int nElem) {
		estrutura = new Tabela(nElem);
	}

	@Override
	public void povoaEstruturaPeloTXT(String fileName) {
		InOutArquivos.leitorTXTPessoaBanco("arquivos_in\\" + fileName, (Tabela) estrutura);
	}
	
	@Override
	public void ordenaEstrutura() {
		Ordenacoes.SortService((Tabela) estrutura, new HeapSortService());
	}

	@Override
	public void geraTXTOrdenado(String fileName) {
		InOutArquivos.escritorTXTPessoaBanco((Tabela) estrutura, fileName);
	}

	@Override
	public void buscaEGeraTXTSaida(String fileName) {

		InOutArquivos.leitorTXTBusca((Tabela) estrutura, fileName);

	}

}
