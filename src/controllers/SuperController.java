package controllers;

import estruturasDados.SuperEstrutura;
import utils.Cronometro;
import utils.InOutCronometro;

public class SuperController implements InterfaceControllers {

	InOutCronometro inOutCron = new InOutCronometro();

	private String os;
	private Integer[] tamanhos = new Integer[] { 500, 1000, 5000, 10000, 50000 };
	private String[] tiposArqs = new String[] { "alea", "ord", "inv" };

	protected SuperEstrutura estrutura;

	public String getSistemaOperacional() {
		return System.getProperty("os.name");
	}

	public void iniciaApp(String metodoNome) {
		for (int k = 0; k < tamanhos.length; k++) {

			for (int j = 0; j < tiposArqs.length; j++) {

				Cronometro.iniciaCronometro();

				for (int count = 0; count < 5; count++) {
					instanciaEstrutura(tamanhos[k]);
					povoaEstruturaPeloTXT("conta" + tamanhos[k] + tiposArqs[j] + ".txt");
					ordenaEstrutura();
					geraTXTOrdenado(metodoNome + tamanhos[k] + tiposArqs[j] + ".txt");
					buscaEGeraTXTSaida(metodoNome + tamanhos[k] + tiposArqs[j] + "ResultBusca.txt");
				}

				Cronometro.paraCronometro();

				System.out.println("Média de execução do metodo" + metodoNome + tamanhos[k] + tiposArqs[j] + ": "
						+ calculaMediaTempoExecucao(Cronometro.getTempoExecucao()) + " milesegundos!\r");

				inOutCron.incrementaTXT(metodoNome, tamanhos[k], tiposArqs[j],calculaMediaTempoExecucao(Cronometro.getTempoExecucao()));

			}
		}

		inOutCron.escreveTempoResultado();
	}

	public void iniciaApp(String metodoNome, String tamanho) {

		for (int j = 0; j < tiposArqs.length; j++) {

			Cronometro.iniciaCronometro();

			for (int count = 0; count < 5; count++) {
				instanciaEstrutura(Integer.parseInt(tamanho));
				povoaEstruturaPeloTXT("conta" + tamanho + tiposArqs[j] + ".txt");
				ordenaEstrutura();
				geraTXTOrdenado(metodoNome + tamanho + tiposArqs[j] + ".txt");
				buscaEGeraTXTSaida(metodoNome + tamanho + tiposArqs[j] + "ResultBusca.txt");
			}

			Cronometro.paraCronometro();

			System.out.println("Média de execução do metodo" + metodoNome + "" + tamanho + tiposArqs[j] + ": "
					+ calculaMediaTempoExecucao(Cronometro.getTempoExecucao()) + " milesegundos!\r");

			inOutCron.incrementaTXT(metodoNome, Integer.parseInt(tamanho), tiposArqs[j],calculaMediaTempoExecucao(Cronometro.getTempoExecucao()));
		}

		inOutCron.limpaArquivo();
		inOutCron.escreveTempoResultado();

	}

	public void instanciaEstrutura(int nElem) {

	}

	public void povoaEstruturaPeloTXT(String fileName) {

	}

	public void ordenaEstrutura() {

	}

	public void geraTXTOrdenado(String fileName) {

	}

	public void buscaEGeraTXTSaida(String fileName) {

	}

	private double calculaMediaTempoExecucao(double tempoGasto) {
		return (tempoGasto / 5);

	}

}
