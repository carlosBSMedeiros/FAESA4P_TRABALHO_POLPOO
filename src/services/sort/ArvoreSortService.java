package services.sort;

import java.util.ArrayList;

import estruturasDados.SuperEstrutura;
import estruturasDados.arvore.Arvore;
import estruturasDados.arvore.ArvoreAVL;
import estruturasDados.arvore.NoArvore;
import estruturasDados.arvore.NoArvoreAVL;
import models.PessoaBanco;

public class ArvoreSortService implements GenericSortService {

	@Override
	public void sort(SuperEstrutura estrutura) {
		sort((Arvore) estrutura);
	}

	// *********************ABB*********************

	public void sort(Arvore arvore) {
		ArrayList<PessoaBanco> vetor = null;
		ArrayList<PessoaBanco> vetorOrdenado = camCentral(vetor, arvore);

		arvore = arvoreBalanceada(vetorOrdenado);
	}

	private ArrayList<PessoaBanco> camCentral(ArrayList<PessoaBanco> vetOrdenado, Arvore arvore) {

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

	private Arvore arvoreBalanceada(ArrayList<PessoaBanco> vetOrdenado) {
		Arvore novaArvore = new Arvore();
		this.balancear(vetOrdenado, novaArvore, 0, vetOrdenado.size() - 1);
		return novaArvore;
	}

	private void balancear(ArrayList<PessoaBanco> vet, Arvore novaArvore, int inic, int fim) {
		int meio;
		if (fim >= inic) {
			meio = (inic + fim) / 2;
			novaArvore.insere(vet.get(meio), novaArvore);
			this.balancear(vet, novaArvore, inic, meio - 1);
			this.balancear(vet, novaArvore, meio + 1, fim);
		}
	}

	// ********************AVL*********************

	public NoArvoreAVL balancearDir(NoArvore no, boolean h) {
		return direita(no, h);
	}
	
	public NoArvoreAVL balancearEsq(NoArvore no, boolean h) {
		return esquerda(no, h);
	}

	private NoArvoreAVL direita(NoArvore no, boolean h) {
		if (h) {
			switch (((NoArvoreAVL) no).getFatorBalanceamento()) {
			case 1:
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
				h = false;
				break;
			case 0:
				((NoArvoreAVL) no).setFatorBalanceamento((byte) -1);
				break;
			case -1:
				no = this.rotacaoDireita(no, h);
			}
		}
		return (NoArvoreAVL) no;
	}

	private NoArvoreAVL esquerda(NoArvore no, boolean h) {
		if (h)
			switch (((NoArvoreAVL) no).getFatorBalanceamento()) {
			case -1:
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
				h = false;
				break;
			case 0:
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 1);
				break;
			case 1:
				no = this.rotacaoEsquerda(no, h);
			}
		return (NoArvoreAVL) no;
	}

	private NoArvoreAVL rotacaoDireita(NoArvore no, boolean h) {
		NoArvore temp1, temp2;
		temp1 = no.getEsq();
		if (((NoArvoreAVL) temp1).getFatorBalanceamento() == -1) {
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
			no = temp1;
		} else {
			temp2 = temp1.getDir();
			temp1.setDir(temp2.getEsq());
			temp2.setEsq(temp1);
			no.setEsq(temp2.getDir());
			temp2.setDir(no);
			if (((NoArvoreAVL) temp2).getFatorBalanceamento() == -1)
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 1);
			else
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
			if (((NoArvoreAVL) temp2).getFatorBalanceamento() == 1)
				((NoArvoreAVL) temp1).setFatorBalanceamento((byte) -1);
			else
				((NoArvoreAVL) temp1).setFatorBalanceamento((byte) 0);
			no = temp2;
		}
		((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
		h = false;
		return (NoArvoreAVL) no;
	}

	private NoArvoreAVL rotacaoEsquerda(NoArvore no, boolean h) {
		NoArvoreAVL temp1, temp2;
		temp1 = (NoArvoreAVL) no.getDir();
		if (temp1.getFatorBalanceamento() == 1) {
			no.setDir(temp1.getEsq());
			temp1.setEsq(no);
			((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
			no = temp1;
		} else {
			temp2 = (NoArvoreAVL) temp1.getEsq();
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			if (temp2.getFatorBalanceamento() == 1)
				((NoArvoreAVL) no).setFatorBalanceamento((byte) -1);
			else
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
			if (temp2.getFatorBalanceamento() == -1)
				temp1.setFatorBalanceamento((byte) 1);
			else
				temp1.setFatorBalanceamento((byte) 0);
			no = temp2;
		}
		((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
		h = false;
		return (NoArvoreAVL) no;
	}

	public ArrayList<PessoaBanco> CamPreOrdem(ArvoreAVL arvore) {
		ArrayList<PessoaBanco> lista = new ArrayList<PessoaBanco>();
		return (FazCamPreOrdem(arvore.getRaiz(), lista));
	}

	private ArrayList<PessoaBanco> FazCamPreOrdem(NoArvore arv, ArrayList<PessoaBanco> lista) {
		if (arv != null) {
			lista.add(arv.getInfo());
			lista = FazCamPreOrdem(arv.getEsq(), lista);
			lista = FazCamPreOrdem(arv.getDir(), lista);
		}
		return lista;
	}

	public ArrayList<PessoaBanco> InOrdem(ArvoreAVL arvore) {
		ArrayList<PessoaBanco> pesssoasBanco = new ArrayList<PessoaBanco>();
		return (FazCamInOrdem(arvore.getRaiz(), pesssoasBanco));
	}

	private ArrayList<PessoaBanco> FazCamInOrdem(NoArvore no, ArrayList<PessoaBanco> lista) {
		if (no != null) {
			lista.add(no.getInfo());
			lista = FazCamInOrdem(no.getEsq(), lista);
			lista = FazCamInOrdem(no.getDir(), lista);
		}
		return lista;
	}

}
