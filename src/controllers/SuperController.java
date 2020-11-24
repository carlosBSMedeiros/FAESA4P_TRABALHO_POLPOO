package controllers;

import estruturasDados.Tabela;
import utils.Cronometro;
import utils.InOut;

public class SuperController implements InterfaceControllers{
	
	Integer[] tamanhos = new Integer[] { 500, 1000, 5000, 10000, 50000 };
	String[] tiposArqs = new String[] { "alea", "ord", "inv" };
	Tabela tabela;
	
	public void iniciaApp(String metodoNome) {
		for (int k = 0; k < tamanhos.length; k++) {

			for (int j = 0; j < tiposArqs.length; j++) {

				for (int i = 5; i > 0; i--) {

					Cronometro.iniciaCronometro();
					instanciaTabela(tamanhos[k]);
					povoaTabelaPeloTXT("conta" + tamanhos[k] + tiposArqs[j] + ".txt");
					ordenaTabela();
					geraTXTOrdenado(metodoNome + tamanhos[k] + tiposArqs[j] + ".txt");
					buscaEGeraTXTSaida(metodoNome + tamanhos[k] + tiposArqs[j]+ "ResultBusca.txt");
					Cronometro.paraCronometro();

				}
			}
		}
		
	}
	
	public void iniciaApp(String metodoNome, String tamanho) {

		for (int j = 0; j < tiposArqs.length; j++) {

			for (int i = 5; i > 0; i--) {

				Cronometro.iniciaCronometro();
				instanciaTabela(Integer.parseInt(tamanho));
				povoaTabelaPeloTXT("conta" + tamanho + tiposArqs[j] + ".txt");
				ordenaTabela();
				geraTXTOrdenado(metodoNome + tamanho + tiposArqs[j] + ".txt");
				buscaEGeraTXTSaida(metodoNome + tamanho + tiposArqs[j] + "ResultBusca.txt");
				Cronometro.paraCronometro();

			}
		}
		

	}

	public void instanciaTabela(int nElem) {
		
	}

	public void povoaTabelaPeloTXT(String fileName) {
		
	}

	public void ordenaTabela() {
		
	}
	
	public void geraTXTOrdenado(String fileName) {
		
	}

	public void buscaEGeraTXTSaida(String fileName) {
		
	}

}
