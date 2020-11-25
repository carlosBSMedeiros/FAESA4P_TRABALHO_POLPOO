package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import controllers.Buscas;
import estruturasDados.FilaPessoa;
import estruturasDados.Tabela;
import estruturasDados.arvore.ArvoreAVL;
import models.PessoaBanco;
import services.find.BuscaBinFindService;

//	//cpf;nome;ag�ncia;conta;saldo

public class InOutArquivos {

	public static void leitorTXTPessoaBanco(String path, Tabela tabela) {
		try {

			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = "";

			while (true) {
				if (linha != null) {

					if (!linha.equals("")) {
						preencheTabela(linha, tabela);
					}

				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void leitorTXTPessoaBanco(String path, ArvoreAVL arvore) {
		try {

			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = "";

			while (true) {
				if (linha != null) {

					if (linha != null && !linha.isEmpty()) {
						preencheArvore(linha, arvore);
					}

				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	private static void preencheArvore(String linha, ArvoreAVL arvore) {
		PessoaBanco pessoa = new PessoaBanco();

		String[] aux = linha.split(";");

		pessoa.setCpf(aux[0]);
		pessoa.setNome(aux[1]);
		pessoa.setAgencia(aux[2]);
		pessoa.setConta(aux[3]);
		pessoa.setSaldo(aux[4]);
		
		arvore.insereRaiz(pessoa);
	}
	
	public static void leitorTXTBusca(ArvoreAVL arvore) {
		BufferedReader buffRead;
		BufferedWriter buffWrite;
		try {

			String path = "arquivos_out/HeapAlea500.txt";
			buffWrite = new BufferedWriter(new FileWriter(path));

			buffRead = new BufferedReader(new FileReader("arquivos_in/Conta.txt"));
			String linha = "";

			while (true) {
				if (linha != null) {

					if (!linha.equals("")) {
						String cpfBusca = linha.split(";")[0];
//						FilaPessoa result = arvore.pesquisaFilaPessoa(cpfBusca);

//						escritorTXTBusca(buffWrite, result, cpfBusca);
					}

				} else
					break;

				linha = buffRead.readLine();
			}

			buffRead.close();
			buffWrite.close();

		} catch (FileNotFoundException e) {
			System.out.println("ARQUIVO \"arquivos_in\\Conta.txt\" DE ENTRADA NÃO ENCONTRADO");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static void escritorTXTPessoaBanco(Tabela tabela, String fileName) {
		try {

			String path = "arquivos_out\\" + fileName;
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
			StringBuilder strb = new StringBuilder();

			for (int i = 0; i < tabela.getNElem(); i++) {
				strb.delete(0, strb.length());

				PessoaBanco aux = tabela.getVetor()[i];

				strb.append(aux.getCpf()).append(";").append(aux.getNome()).append(";").append(aux.getAgencia())
						.append(";").append(aux.getConta()).append(";").append(aux.getSaldo());

				buffWrite.append(strb.toString() + "\n");

			}

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void leitorTXTBusca(Tabela tabela, String fileName) {
		BufferedReader buffRead;
		BufferedWriter buffWrite;
		try {

			String path = "arquivos_out\\" + fileName;
			buffWrite = new BufferedWriter(new FileWriter(path));

			buffRead = new BufferedReader(new FileReader("arquivos_in\\Conta.txt"));
			String linha = "";

			while (true) {
				if (linha != null) {

					if (!linha.equals("")) {
						String cpfBusca = linha.split(";")[0];
						FilaPessoa result = Buscas.FindService(tabela, cpfBusca, new BuscaBinFindService());
						
						escritorTXTBusca(buffWrite, result, cpfBusca);
					}

				} else
					break;

				linha = buffRead.readLine();
			}

			buffRead.close();
			buffWrite.close();

		} catch (FileNotFoundException e) {
			System.out.println("ARQUIVO \"arquivos_in\\Conta.txt\" DE ENTRADA NãO ENCONTRADO");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean escritorTXTBusca(BufferedWriter buffWrite, FilaPessoa result, String cpfBusca) {

		try {

			if (result == null || result.getSize() == 0) {

				String msg = montaMsgDoTXTSaida(null, cpfBusca);
				buffWrite.append(msg).append("\n");
				return false;

			} else {

				String msg = montaMsgDoTXTSaida(result, cpfBusca);
				buffWrite.append(msg).append("\n");

			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static String montaMsgDoTXTSaida(FilaPessoa result, String cpfBusca) {
		StringBuilder strb = new StringBuilder();
		
		strb.append("CPF ").append(cpfBusca);
		
		if(result == null) {
			strb.append("\n NENHUM REGISTRO COM O CPF ").append(cpfBusca).append("\n");
		} else {
			
			Double saldoTotal = 0.0;

			strb.append("   NOME:").append(result.getPrimeiro().getNome()).append("\n");

			while(result.getSize() > 0) {
			
				PessoaBanco pessoaBanco = result.desenfileirar();
				
				strb.append("Ag: ").append(pessoaBanco.getAgencia());
				
				switch(pessoaBanco.getConta().substring(0, 3)) {
				
					case "001":
						strb.append(" Conta Comum: ");
						break;
					
					case "002":
						strb.append(" Conta Especial: ");
						break;
		
					case "010":
						strb.append(" Conta Poupança: ");
						break;
		
					default:
						strb.append(" Conta não especificada: ");
						break;
	
				}
				
				strb.append(pessoaBanco.getConta()).append(" Saldo: R$ ").append(pessoaBanco.getSaldo() + "\n");
				saldoTotal += Double.parseDouble(pessoaBanco.getSaldo());
			//Ag: 1234 Conta Comum: 00112345 Saldo: R$ 2300.00
			}
			
			strb.append("Saldo Total: R$").append(saldoTotal).append("\n");
			
		}
		
		return strb.toString();
	}

}
