package controllers;

import estruturasDados.Tabela;
import utils.Cronometro;

public class SuperController implements InterfaceControllers{
	
	private Integer[] tamanhos = new Integer[] { 500, 1000, 5000, 10000, 50000 };
	private String[] tiposArqs = new String[] { "alea", "ord", "inv" };
	private long temposExec;
	private int contTempos;
	protected Tabela tabela;
	
	public void iniciaApp(String metodoNome) {
		for (int k = 0; k < tamanhos.length; k++) {

			for (int j = 0; j < tiposArqs.length; j++) {

				temposExec = 0;
				contTempos = 0;
				
				for (int i = 5; i > 0; i--) {

					Cronometro.iniciaCronometro();
					instanciaTabela(tamanhos[k]);
					povoaTabelaPeloTXT("conta" + tamanhos[k] + tiposArqs[j] + ".txt");
					ordenaTabela();
					geraTXTOrdenado(metodoNome + tamanhos[k] + tiposArqs[j] + ".txt");
					buscaEGeraTXTSaida(metodoNome + tamanhos[k] + tiposArqs[j]+ "ResultBusca.txt");
					Cronometro.paraCronometro();
					somaTempoExecucao(Cronometro.getTempoExecucao());
				}
				
				System.out.println("Média de tempo de execução do método " + metodoNome + tamanhos[k] + tiposArqs[j]
						+ ": " + calculaMediaTempoExecucao() + " segundos!\r");
				
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
	
	private void somaTempoExecucao(long tempoExec) {
		this.temposExec += tempoExec;
		contTempos++;
	}
	
	private long calculaMediaTempoExecucao() {
		long result = this.temposExec / contTempos;
		return result;
	}

}
