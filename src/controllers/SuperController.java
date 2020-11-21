package controllers;

import java.util.concurrent.TimeUnit;

import estruturasDados.SuperEstrutura;
import utils.Cronometro;

public class SuperController implements InterfaceControllers{
	
	private Integer[] tamanhos = new Integer[] { 500, 1000, 5000, 10000, 50000 };
	private String[] tiposArqs = new String[] { "alea", "ord", "inv" };
	private Long temposExec;
	private int contTempos;
	protected SuperEstrutura estrutura;
	
	private Cronometro cronometro = new Cronometro();
	
	public void iniciaApp(String metodoNome) {
		for (int k = 0; k < tamanhos.length; k++) {

			for (int j = 0; j < tiposArqs.length; j++) {

				temposExec = (long) 0;
				contTempos = 0;
				
				for (int i = 5; i > 0; i--) {

					cronometro.iniciaCronometro();
					instanciaEstrutura(tamanhos[k]);
					povoaEstruturaPeloTXT("conta" + tamanhos[k] + tiposArqs[j] + ".txt");
					ordenaEstrutura();
					geraTXTOrdenado(metodoNome + tamanhos[k] + tiposArqs[j] + ".txt");
					buscaEGeraTXTSaida(metodoNome + tamanhos[k] + tiposArqs[j]+ "ResultBusca.txt");
					cronometro.paraCronometro();
					somaTempoExecucao(cronometro.getTempoExecucao());
				}
				
//				System.out.printf("Média de tempo de execução do método " + metodoNome + tamanhos[k] + tiposArqs[j]
//						+ ": %.6f  segundos!\r", calculaMediaTempoExecucao());
				
				System.out.println("Média de tempo de execução do método " + metodoNome + tamanhos[k] + tiposArqs[j]
						+ ": " + calculaMediaTempoExecucao() +" segundos!\r");
				
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
	
	private void somaTempoExecucao(Long tempoExec) {
		this.temposExec += tempoExec;
		contTempos++;
	}
	
	private long calculaMediaTempoExecucao() {
		this.temposExec = this.temposExec / contTempos;
		
		
		return this.temposExec;
	}

}
