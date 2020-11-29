package controllers;

import estruturasDados.Tabela;
import estruturaDados.Hash.Hash;
import utils.InOutArquivos;

public class HashingController extends SuperController {
	
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
		estrutura = new Hash(nElem);
	}

	@Override
	public void povoaEstruturaPeloTXT(String fileName) {
		if (getSistemaOperacional() == "Linux") {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in/" + fileName, (Hash) estrutura);
		}
		
		if (getSistemaOperacional() == "Windows") {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in\\" + fileName,(Hash) estrutura);
		}
	}
	
//	@Override
//	public void ordenaEstrutura() {
//		Ordenacoes.SortService((Tabela) estrutura, new HeapSortService());
//	}
//
//	@Override
//	public void geraTXTOrdenado(String fileName) {
//		InOutArquivos.escritorTXTPessoaBanco((Tabela) estrutura, fileName);
//	}
//
//	@Override
//	public void buscaEGeraTXTSaida(String fileName) {
//
//		InOutArquivos.leitorTXTBusca((Tabela) estrutura, fileName);
//
//	}

}
