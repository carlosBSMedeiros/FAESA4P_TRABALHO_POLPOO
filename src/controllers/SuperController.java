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
				try {
					Cronometro.iniciaCronometro();

					for (int count = 0; count < 5; count++) {
						padrao(metodoNome, Integer.toString(tamanhos[k]), tiposArqs[j]);
					}

					Cronometro.paraCronometro();

					System.out.println("Media de execução do metodo" + metodoNome + tamanhos[k] + tiposArqs[j] + ": "+ calculaMediaTempoExecucao(Cronometro.getTempoExecucao()) + " milesegundos!\r");
					inOutCron.incrementaTXT(metodoNome, tamanhos[k], tiposArqs[j],String.valueOf(calculaMediaTempoExecucao(Cronometro.getTempoExecucao())) + " ms");
					
				} catch (StackOverflowError e) {
					inOutCron.incrementaTXT(metodoNome, tamanhos[k], tiposArqs[j], "Overflow");
					System.out.println("Media de execução do metodo" + metodoNome + tamanhos[k] + tiposArqs[j] + ": "+ "StackOverflowError");
				}
			}
		}

		inOutCron.escreveTempoResultado();

	}

	public void iniciaApp(String metodoNome, String tamanho) {
		
		for (int j = 0; j < tiposArqs.length; j++) {

			try {
				Cronometro.iniciaCronometro();

				for (int count = 0; count < 5; count++) {
					padrao(metodoNome, tamanho, tiposArqs[j]);
				}

				Cronometro.paraCronometro();

				System.out.println("Media de execucao do metodo" + metodoNome + "" + tamanho + tiposArqs[j] + ": "+ calculaMediaTempoExecucao(Cronometro.getTempoExecucao()) + " milesegundos!\r");
				inOutCron.incrementaTXT(metodoNome, Integer.parseInt(tamanho), tiposArqs[j],String.valueOf((calculaMediaTempoExecucao(Cronometro.getTempoExecucao()))) + " ms");

			} catch (StackOverflowError e) {
				inOutCron.incrementaTXT(metodoNome, Integer.parseInt(tamanho), tiposArqs[j], "Overflow");
				System.out.println("Media de execucao do metodo" + metodoNome + tamanho + tiposArqs[j] + ": "+ "StackOverflowError");
			}

		}

		inOutCron.limpaArquivo();
		inOutCron.escreveTempoResultado();

	}

	private void padrao(String metodoNome, String tamanho, String tipo) {
		instanciaEstrutura(Integer.parseInt(tamanho));
		povoaEstruturaPeloTXT("conta" + tamanho +tipo + ".txt");
		ordenaEstrutura();
		geraTXTOrdenado(metodoNome + tamanho + tipo + ".txt");
		buscaEGeraTXTSaida(metodoNome + tamanho + tipo + "ResultBusca.txt");
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
