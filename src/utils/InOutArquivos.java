package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import controllers.Buscas;
import estruturasDados.FilaPessoa;
import estruturasDados.Tabela;
import models.PessoaBanco;
import services.find.BuscaBinFindService;

//	//cpf;nome;agência;conta;saldo

public class InOutArquivos {

	public static void leitorTXTPessoaBanco(String path, Tabela tabela) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while (true) {
			if (linha != null) {
				
				if(!linha.equals("")) {
					preencheTabela(linha, tabela);
				}
				
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
	
	private static void preencheTabela(String linha, Tabela tabela) {
		PessoaBanco pessoa = new PessoaBanco();
		
		String[] aux = linha.split(";");
		
		pessoa.setCpf(aux[0]);
		pessoa.setNome(aux[1]);
		pessoa.setAgencia(aux[2]);
		pessoa.setConta(aux[3]);
		pessoa.setSaldo(aux[4]);
		
		tabela.addItem(pessoa);
	}
	
	public static void escritorTXTPessoaBanco(Tabela tabela) throws IOException  {
		String path =  "D:\\WorkSpaces\\TrabalhoPOLPOO\\FAESA4P_TRABALHO_POLPOO\\archives\\HeapAlea500.txt";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		StringBuilder strb = new StringBuilder();
		
		for(int i = 0; i < tabela.getNElem(); i++) {
			strb.delete(0, strb.length());
			
			PessoaBanco aux = tabela.getVetor()[i];
			
			strb.append(aux.getCpf()).append(";")
			.append(aux.getNome()).append(";")
			.append(aux.getAgencia()).append(";")
			.append(aux.getConta()).append(";")
			.append(aux.getSaldo());
			
			buffWrite.append(strb.toString() + "\n");

		}
		
		buffWrite.close();
		
	}
	
	public static void leitorTXTBusca(String path, Tabela tabela) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while (true) {
			if (linha != null) {
				
				if(!linha.equals("")) {
					String[] cpfBusca = linha.split(";");
					FilaPessoa result = Buscas.FindService(tabela, cpfBusca[0], new BuscaBinFindService());
					
				}
				
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
	
}
