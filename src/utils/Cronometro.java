package utils;

public class Cronometro {

	private long tempoExec;
	
	
	public void iniciaCronometro() { 
		tempoExec = System.nanoTime();
	}
	
	public void paraCronometro() {
		tempoExec = System.nanoTime() - tempoExec;
	}
	
	public Long getTempoExecucao() {
		tempoExec /= 1_000_000_00;
		return tempoExec;
	}
}
