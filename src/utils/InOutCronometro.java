package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class InOutCronometro {
	
	private static BufferedWriter buffWrite;
	private StringBuilder strb;
	
	public InOutCronometro() {
		strb = new StringBuilder();
	}
	
	public void incrementaTXT(String metodoNome, int tamanho, String tipoArqs, double tempoExec) {
		strb.append(metodoNome).append(";").append(tamanho).append(";").append(tipoArqs).append(";").append(tempoExec).append("\n");

	}
	
	public void escreveTempoResultado() {
		
		try {
			
			buffWrite = new BufferedWriter(new FileWriter("arquivos_out_cronometro/resultadosTempos.txt",true));
			buffWrite.append(strb.toString());
			finalizaBuffWrite();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void finalizaBuffWrite() {
		try {
			buffWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void limpaArquivo() {
		try {
			buffWrite = new BufferedWriter(new FileWriter("arquivos_out_cronometro/resultadosTempos.txt",false));
			buffWrite.append("");
			buffWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static List<String[]> leitorTempo() {
		
		List<String[]> listTempos = new ArrayList<String[]>();
		
		try {

			BufferedReader buffRead = new BufferedReader(new FileReader("arquivos_out_cronometro/resultadosTempos.txt"));
			String linha = "";

			while (true) {
				if (linha != null) {

					if (!linha.equals("")) {
						listTempos.add(linha.split(";"));
					}

				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listTempos;
	}


}
