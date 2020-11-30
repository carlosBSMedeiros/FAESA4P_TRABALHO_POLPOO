package controllers;

import estruturasDados.Tabela;
import services.find.BuscaBinFindService;
import services.sort.QuickSortService;
import utils.Cronometro;
import utils.InOutArquivos;

public class QuickSortController extends SuperController{

	@Override
	public void iniciaApp() {
		super.iniciaApp("Quick");
	}
	
	@Override
	public void iniciaApp(String tamanho) {
		super.iniciaApp("Quick",tamanho);
	}


	@Override
	public void instanciaEstrutura(int nElem) {
		estrutura = new Tabela(nElem);
	}

	@Override
	public void povoaEstruturaPeloTXT(String fileName) {
		if (getSistemaOperacional() == "Linux") {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in/" + fileName, (Tabela) estrutura);
		}else {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in\\" + fileName, (Tabela) estrutura);
		}
	}
	
	@Override
	public void ordenaEstrutura() {
		Ordenacoes.SortService((Tabela) estrutura, new QuickSortService());
	}

	@Override
	public void geraTXTOrdenado(String fileName) {
		InOutArquivos.escritorTXTPessoaBanco((Tabela) estrutura, fileName);
	}

	@Override
	public void buscaEGeraTXTSaida(String fileName) {
		InOutArquivos.leitorTXTBusca((Tabela) estrutura, fileName, new BuscaBinFindService());
		
	}
}
