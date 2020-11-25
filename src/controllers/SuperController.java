package controllers;

import estruturasDados.SuperEstrutura;
import utils.Cronometro;

public class SuperController implements InterfaceControllers{
	
	private Integer[] tamanhos = new Integer[] { 500, 1000, 5000, 10000, 50000 };
	private String[] tiposArqs = new String[] { "alea", "ord", "inv" };
	private long temposExec;
	private int contTempos;
	protected SuperEstrutura estrutura;
	
	public void iniciaApp(String metodoNome) {
		for (int k = 0; k < tamanhos.length; k++) {

			for (int j = 0; j < tiposArqs.length; j++) {

				temposExec = 0;
				contTempos = 0;
				
				for (int i = 5; i > 0; i--) {

					Cronometro.iniciaCronometro();
					instanciaEstrutura(tamanhos[k]);
					povoaEstruturaPeloTXT("conta" + tamanhos[k] + tiposArqs[j] + ".txt");
					ordenaEstrutura();
					geraTXTOrdenado(metodoNome + tamanhos[k] + tiposArqs[j] + ".txt");
					buscaEGeraTXTSaida(metodoNome + tamanhos[k] + tiposArqs[j]+ "ResultBusca.txt");
					Cronometro.paraCronometro();
					somaTempoExecucao(Cronometro.getTempoExecucao());
				}
				
				System.out.println("Média de execução do metodo" + metodoNome + tamanhos[k] + tiposArqs[j]
						+ ": " + calculaMediaTempoExecucao() + " segundos!\r");
				
			}
		}
		
	}
	
	public void iniciaApp(String metodoNome, String tamanho) {

		for (int j = 0; j < tiposArqs.length; j++) {

			for (int i = 5; i > 0; i--) {

				Cronometro.iniciaCronometro();
				instanciaEstrutura(Integer.parseInt(tamanho));
				povoaEstruturaPeloTXT("conta" + tamanho + tiposArqs[j] + ".txt");
				ordenaEstrutura();
				geraTXTOrdenado(metodoNome + tamanho + tiposArqs[j] + ".txt");
				buscaEGeraTXTSaida(metodoNome + tamanho + tiposArqs[j] + "ResultBusca.txt");
				Cronometro.paraCronometro();

			}
		}
		

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
	
	private void somaTempoExecucao(double tempoExec) {
		this.temposExec += tempoExec;
		contTempos++;
	}
	
	private long calculaMediaTempoExecucao() {
		long result = this.temposExec / contTempos;
		return result;
	}

}
