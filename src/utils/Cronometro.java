package utils;

public class Cronometro {

	static long tempoExec;
	
	
	public static void iniciaCronometro() { 
		tempoExec = System.currentTimeMillis();
	}
	
	public static void paraCronometro() {
		tempoExec = System.currentTimeMillis() - tempoExec;
	}
	
	public static long getTempoExecucao() {
		return tempoExec / 1000;
	}
}
