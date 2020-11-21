package services.find;

import java.util.ArrayList;

import estruturasDados.FilaPessoa;
import estruturasDados.SuperEstrutura;
import estruturasDados.arvore.Arvore;
import estruturasDados.arvore.NoArvore;
import metodos.Compare;
import models.PessoaBanco;

public class ArvoreFindService implements GenericFindService {

	@Override
	public FilaPessoa find(SuperEstrutura superEstrutura, String cpfBusca) {
		return find((Arvore) superEstrutura, cpfBusca);
	}
	
	private FilaPessoa find(Arvore arvore, String cpfBusca) {

		FilaPessoa result =  new FilaPessoa();
		
		NoArvore no = this.find(cpfBusca, arvore.getRaiz());
		
		if (no != null) {
			return result;
		} else {
			return null;
		}
		
	}
	
	private NoArvore find(String cpfBusca, NoArvore no) {
		NoArvore noArvore = no;
		
		if (noArvore != null) {
			if (cpfBusca.compareTo(no.getInfo().getCpf()) < 0) {
				noArvore = this.find(cpfBusca, noArvore.getEsq());
			} else {
				if (cpfBusca.compareTo(no.getInfo().getCpf()) > 0) {
					noArvore = this.find(cpfBusca, noArvore.getDir());
				}
			}
		}
		return noArvore;
	}
	
	public ArrayList<PessoaBanco> camCentral(ArrayList<PessoaBanco> vetOrdenado, SuperEstrutura superEstrutura) {
		
		Arvore arvore = (Arvore) superEstrutura;
		
		return (this.fazCamCentral(arvore.getRaiz(), vetOrdenado));
		
	}
	
	private ArrayList<PessoaBanco> fazCamCentral(NoArvore noArvore, ArrayList<PessoaBanco> vetOrdenado) {
		if (noArvore != null) {
			vetOrdenado = this.fazCamCentral(noArvore.getEsq(), vetOrdenado);
			vetOrdenado.add(noArvore.getInfo());
			vetOrdenado = this.fazCamCentral(noArvore.getDir(), vetOrdenado);
		}
		return vetOrdenado;
	}
	
	public Arvore arvoreBalanceada(ArrayList<PessoaBanco> vetOrdenado) {
		Arvore temp = new Arvore();
		this.balancear(vetOrdenado, temp, 0, vetOrdenado.size() - 1);
		return temp;
	}
	
	private void balancear(ArrayList<PessoaBanco> vet, Arvore temp, int inic, int fim) {
		int meio;
		if (fim >= inic) {
			meio = (inic+fim)/2;
//			temp.insere(vet.get(meio));
			this.balancear(vet, temp, inic, meio - 1);
			this.balancear(vet, temp, meio + 1, fim);
		}
	}

}
