package controllers;

import utils.Cronometro;

public interface InterfaceControllers {

	public default void iniciaApp() {
		Cronometro.iniciaCronometro();
		instanciaTabela(500);
		povoaTabelaPeloTXT("");
		ordenaTabela();
		geraTXTOrdenado("");
		buscaEGeraTXTSaida("");
		Cronometro.paraCronometro();
	}

	public void instanciaTabela(int nElem);

	public void povoaTabelaPeloTXT(String fileName);

	public void ordenaTabela();

	public void geraTXTOrdenado(String fileName);

	public void buscaEGeraTXTSaida(String fileName);

}
