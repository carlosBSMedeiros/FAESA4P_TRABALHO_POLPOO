package utils;

public class Cronometro {
	static double inicio;
	static double tempoExec;

	public static void iniciaCronometro() {
		inicio = System.currentTimeMillis();
	}

	public static void paraCronometro() {
		tempoExec = (System.currentTimeMillis()) - inicio;
	}

	public static double getTempoExecucao() {
		return tempoExec;
	}
}
