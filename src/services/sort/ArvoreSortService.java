package services.sort;

import java.util.ArrayList;

import estruturasDados.SuperEstrutura;
import estruturasDados.arvore.ArvoreABB;
import estruturasDados.arvore.ArvoreAVL;
import models.PessoaBanco;

public class ArvoreSortService implements GenericSortService {

	@Override
	public void sort(SuperEstrutura estrutura) {
		if (estrutura instanceof ArvoreAVL)
			sort((ArvoreAVL) estrutura);
		else if (estrutura instanceof ArvoreABB)
			sort((ArvoreABB) estrutura);
	}

	// *********************ABB*********************

	public void sort(ArvoreABB arvore) {
		ArrayList<PessoaBanco> vetorOrdenado = arvore.InOrdem();

		arvore = arvoreBalanceada(vetorOrdenado);
	}


	private ArvoreABB arvoreBalanceada(ArrayList<PessoaBanco> vetOrdenado) {
		ArvoreABB arvore = new ArvoreABB();
		this.balancear(vetOrdenado, arvore, 0, vetOrdenado.size() - 1);
		return arvore;
	}

	private void balancear(ArrayList<PessoaBanco> vet, ArvoreABB arvore, int inic, int fim) {
		int meio;
		if (fim >= inic) {
			meio = (inic + fim) / 2;
			arvore.insere(vet.get(meio), arvore);
			this.balancear(vet, arvore, inic, meio - 1);
			this.balancear(vet, arvore, meio + 1, fim);
		}
	}

	// ********************AVL*********************

	public void sort(ArvoreAVL arvore) {
	}

}
