package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import controllers.Buscas;
import estruturaDados.Hash.Hash;
import estruturasDados.FilaPessoa;
import estruturasDados.SuperEstrutura;
import estruturasDados.Tabela;
import estruturasDados.ListaEncadeada.No;
import estruturasDados.arvore.ArvoreABB;
import estruturasDados.arvore.ArvoreAVL;
import models.PessoaBanco;
import services.find.GenericFindService;

//	//cpf;nome;ag�ncia;conta;saldo

public class InOutArquivos {

	public static void leitorTXTPessoaBanco(String path, SuperEstrutura estrutura) {
		try {

			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = "";
			while (true) {
				if (linha != null) {

					if (!linha.equals("")) {
						preencheEstrutura(linha, estrutura);
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

	private static void preencheEstrutura(String linha, SuperEstrutura estrutura) {
		PessoaBanco pessoa = new PessoaBanco();

		String[] aux = linha.split(";");

		pessoa.setCpf(aux[0]);
		pessoa.setNome(aux[1]);
		pessoa.setAgencia(aux[2]);
		pessoa.setConta(aux[3]);
		pessoa.setSaldo(aux[4]);

		if (estrutura instanceof Tabela) {
			((Tabela) estrutura).addItem(pessoa);
		} else if (estrutura instanceof ArvoreAVL) {
			((ArvoreAVL) estrutura).insereRaiz(pessoa);
		} else if (estrutura instanceof Hash) {
			((Hash) estrutura).insere(pessoa);
		} else if (estrutura instanceof ArvoreABB) {
			((ArvoreABB) estrutura).insereRaiz(pessoa);
		}

	}

	public static void leitorTXTBusca(SuperEstrutura estrutura, String fileName, GenericFindService service) {
		BufferedReader buffRead;
		BufferedWriter buffWrite;
		try {

			String path = "arquivos_out/" + fileName;
			buffWrite = new BufferedWriter(new FileWriter(path));

			buffRead = new BufferedReader(new FileReader("arquivos_in/Conta.txt"));
			String linha = "";

			while (true) {
				if (linha != null) {

					if (!linha.equals("")) {
						String cpfBusca = linha.split(";")[0];
						FilaPessoa result = Buscas.FindService(estrutura, cpfBusca, service);
						escritorTXTBusca(buffWrite, result, cpfBusca);
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

			String path = "arquivos_out/" + fileName;
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

	public static void escritorTXTPessoaBanco(ArvoreAVL arvore, String fileName) {
		try {

			String path = "arquivos_out/" + fileName;
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
			StringBuilder strb = new StringBuilder();
			ArrayList<PessoaBanco> pesssoasBanco = arvore.InOrdem();

			for (PessoaBanco pessoaBanco : pesssoasBanco) {
				strb.delete(0, strb.length());

				PessoaBanco aux = pessoaBanco;

				strb.append(aux.getCpf()).append(";").append(aux.getNome()).append(";").append(aux.getAgencia())
						.append(";").append(aux.getConta()).append(";").append(aux.getSaldo());

				buffWrite.append(strb.toString() + "\n");

			}

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void escritorTXTPessoaBanco(ArvoreABB arvore, String fileName) {
		try {

			String path = "arquivos_out/" + fileName;
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
			StringBuilder strb = new StringBuilder();
			ArrayList<PessoaBanco> pesssoasBanco = arvore.InOrdem();

			for (PessoaBanco pessoaBanco : pesssoasBanco) {
				strb.delete(0, strb.length());

				PessoaBanco aux = pessoaBanco;

				strb.append(aux.getCpf()).append(";").append(aux.getNome()).append(";").append(aux.getAgencia())
						.append(";").append(aux.getConta()).append(";").append(aux.getSaldo());

				buffWrite.append(strb.toString() + "\n");

			}

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void escritorTXTPessoaBanco(Hash hash, String fileName) {
		try {

			String path = "arquivos_out/" + fileName;
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
			StringBuilder strb = new StringBuilder();

			for (Integer i : hash.getIndexs()) {
				No atual = hash.getHashEncadeado()[i].getInfos().getPrim();

				while (atual != null) {

					strb.delete(0, strb.length());

					PessoaBanco aux = atual.getInfo();

					strb.append(aux.getCpf()).append(";").append(aux.getNome()).append(";").append(aux.getAgencia())
							.append(";").append(aux.getConta()).append(";").append(aux.getSaldo());

					buffWrite.append(strb.toString() + "\n");

					atual = atual.getProx();

				}

			}

			buffWrite.close();

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

		if (result == null) {
			strb.append("\n NENHUM REGISTRO COM O CPF ").append(cpfBusca).append("\n");
		} else {

			Double saldoTotal = 0.0;

			strb.append("   NOME:").append(result.getPrimeiro().getNome()).append("\n");

			while (result.getSize() > 0) {

				PessoaBanco pessoaBanco = result.desenfileirar();

				strb.append("Ag: ").append(pessoaBanco.getAgencia());
				strb.append(pessoaBanco.getTipoConta());
				strb.append(pessoaBanco.getConta()).append(" Saldo: R$ ").append(pessoaBanco.getSaldo() + "\n");
				saldoTotal += Double.parseDouble(pessoaBanco.getSaldo());
				// Ag: 1234 Conta Comum: 00112345 Saldo: R$ 2300.00
			}

			strb.append("Saldo Total: R$").append(saldoTotal).append("\n");

		}

		return strb.toString();
	}

}
