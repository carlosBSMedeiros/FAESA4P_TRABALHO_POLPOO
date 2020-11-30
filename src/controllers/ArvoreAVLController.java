package controllers;

import estruturasDados.arvore.ArvoreAVL;
import services.find.ArvoreFindService;
import services.sort.ArvoreSortService;
import utils.InOutArquivos;

public class ArvoreAVLController extends SuperController {

	@Override
	public void iniciaApp() {
		super.iniciaApp("ArvoreAVL");
	}
	
	@Override
	public void iniciaApp(String tamanho) {
		super.iniciaApp("ArvoreAVL", tamanho);
	}

	@Override
	public void instanciaEstrutura(int nElem) {
		estrutura = new ArvoreAVL();
	}

	@Override
	public void povoaEstruturaPeloTXT(String fileName) {
		if (getSistemaOperacional().equals("Linux")) {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in/" + fileName, (ArvoreAVL) estrutura);
		}else {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in\\" + fileName, (ArvoreAVL) estrutura);
		}
	}

	@Override
	public void ordenaEstrutura() {
		Ordenacoes.SortService((ArvoreAVL) estrutura, new ArvoreSortService());
	}

	@Override
	public void geraTXTOrdenado(String fileName) {
		InOutArquivos.escritorTXTPessoaBanco((ArvoreAVL) estrutura, fileName);
	}

	@Override
	public void buscaEGeraTXTSaida(String fileName) {

		InOutArquivos.leitorTXTBusca((ArvoreAVL) estrutura, fileName, new ArvoreFindService());

	}

}
