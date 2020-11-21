package controllers;

import utils.Cronometro;

public interface InterfaceControllers {

	public default void iniciaApp() {
		Cronometro.iniciaCronometro();
		instanciaEstrutura(500);
		povoaEstruturaPeloTXT("");
		ordenaEstrutura();
		geraTXTOrdenado("");
		buscaEGeraTXTSaida("");
		Cronometro.paraCronometro();
	}

	public void instanciaEstrutura(int nElem);

	public void povoaEstruturaPeloTXT(String fileName);

	public void ordenaEstrutura();

	public void geraTXTOrdenado(String fileName);

	public void buscaEGeraTXTSaida(String fileName);

}
