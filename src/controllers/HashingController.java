package controllers;

import estruturaDados.Hash.Hash;
import services.find.HashFindService;
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
		}else {
			InOutArquivos.leitorTXTPessoaBanco("arquivos_in\\" + fileName,(Hash) estrutura);
		}
		
	}


	@Override
	public void geraTXTOrdenado(String fileName) {
		InOutArquivos.escritorTXTPessoaBanco((Hash) estrutura, fileName);
	}

	@Override
	public void buscaEGeraTXTSaida(String fileName) {
		InOutArquivos.leitorTXTBusca((Hash) estrutura, fileName, new HashFindService());

	}

}
