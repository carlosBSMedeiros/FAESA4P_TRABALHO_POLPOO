package controllers;

import estruturasDados.Tabela;
import models.PessoaBanco;

public class Ordenacoes {

	public static void HeapSort(Tabela tabela) {

		int dir = tabela.getNElem() - 1;
		int esq = (dir - 1) / 2;
		PessoaBanco temp;
		while (esq >= 0) {
			refazHeap(esq, tabela.getNElem() - 1, tabela);
			esq--;
		}
		while (dir > 0) {
			temp = tabela.getVetor()[0];
			tabela.getVetor()[0] = tabela.getVetor()[dir];
			tabela.getVetor()[dir] = temp;
			dir--;
			refazHeap(0, dir, tabela);
		}
	}

	private static void refazHeap(int esq, int dir, Tabela tabela) {
		int i = esq;
		int mF = 2 * i + 1; // maior filho
		PessoaBanco raiz = tabela.getVetor()[i];
		boolean heap = false;
		while ((mF <= dir) && (!heap)) {
			if (mF < dir) {
				if (comparaPessoa(tabela.getVetor()[mF], tabela.getVetor()[mF + 1]) < 0) {
					mF++;
				}
			}
			
		 if (comparaPessoa(raiz,tabela.getVetor()[mF]) < 0) {
				tabela.getVetor()[i] = tabela.getVetor()[mF];
				i = mF;
				mF = 2 * i + 1;
			} else
				heap = true;
		}
		tabela.getVetor()[i] = raiz;
	}
	
	private static byte comparaPessoa(PessoaBanco pessoa1, PessoaBanco pessoa02) {
		
		int compareCpf = pessoa1.getCpf().compareTo(pessoa02.getCpf());
		
		if(compareCpf < 0) {
			return -1;
		} else if(compareCpf > 0) {
			return 1;
		} else {
			return comparaPessoaAgencia(pessoa1, pessoa02);
		}
	}
	
	private static byte comparaPessoaAgencia(PessoaBanco pessoa1, PessoaBanco pessoa02) {
		
		int compareAgencia = pessoa1.getAgencia().compareTo(pessoa02.getAgencia());
		
		if(compareAgencia < 0) {
			return -1;
		} else if(compareAgencia > 0) {
			return 1;
		} else {
			return comparaPessoaConta(pessoa1, pessoa02);
		}
	}
	
	private static byte comparaPessoaConta(PessoaBanco pessoa1, PessoaBanco pessoa02) {
		int comparaConta = pessoa1.getConta().compareTo(pessoa02.getConta());
		
		if(comparaConta < 0) {
			return -1;
		} else if(comparaConta > 0) {
			return 1;
		} else  {
			return 0;
		}
		
		
	}
	
}
