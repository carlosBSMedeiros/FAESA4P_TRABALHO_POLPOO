package estruturasDados.arvore;

import java.util.ArrayList;

import metodos.Compare;
import models.PessoaBanco;

public class ArvoreAVL {

	private NoArvoreAVL raiz;
	private boolean h;

	public ArvoreAVL() {
		this.raiz = null;
		this.h = true;
	}

	public NoArvoreAVL getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvoreAVL raiz) {
		this.raiz = raiz;
	}

	public boolean isH() {
		return h;
	}

	public void setH(boolean h) {
		this.h = h;
	}

	public void insereRaiz(PessoaBanco pessoaBanco) {
		this.raiz = this.insere(pessoaBanco, this.raiz);
	}

	private NoArvoreAVL insere(PessoaBanco pessoaBanco, NoArvoreABB no) {
		if (no == null) {
			NoArvoreAVL novo = new NoArvoreAVL(pessoaBanco);
			this.h = true;
			return novo;
		} else {
			if (Compare.pessoa(pessoaBanco, no.getInfo()) < 0) {
				// Insere � esquerda e verifica se precisa balancear � direita
				no.setEsq(this.insere(pessoaBanco, no.getEsq()));
				no = this.balancearDir(no);
				return (NoArvoreAVL)no;
			} else {
//				 Insere � direita e verifica se precisa balancear � esquerda
				no.setDir(this.insere(pessoaBanco, no.getDir()));
				no = this.balancearEsq(no);
				return (NoArvoreAVL)no;
			}
		}
	}

	private NoArvoreAVL balancearDir(NoArvoreABB no) {
		if (this.h) {
			switch (((NoArvoreAVL) no).getFatorBalanceamento()) {
			case 1:
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				((NoArvoreAVL) no).setFatorBalanceamento((byte) -1);
				break;
			case -1:
				no = this.rotacaoDireita(no);
			}
		}
		return (NoArvoreAVL) no;
	}

	private NoArvoreAVL balancearEsq(NoArvoreABB no) {
		if (this.h)
			switch (((NoArvoreAVL) no).getFatorBalanceamento()) {
			case -1:
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				((NoArvoreAVL) no).setFatorBalanceamento((byte) 1);
				break;
			case 1:
				no = this.rotacaoEsquerda(no);
			}
		return (NoArvoreAVL) no;
	}

	private NoArvoreAVL rotacaoDireita(NoArvoreABB no) {
		NoArvoreABB temp1, temp2;
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
		this.h = false;
		return (NoArvoreAVL) no;
	}

	private NoArvoreAVL rotacaoEsquerda(NoArvoreABB no) {
		NoArvoreAVL temp1, temp2;
		temp1 = (NoArvoreAVL) no.getDir();
		if (temp1.getFatorBalanceamento() == 1) {
			no.setDir(temp1.getEsq());
			temp1.setEsq(no);
			((NoArvoreAVL) no).setFatorBalanceamento((byte) 0);
			no = temp1;
		} else {
			temp2 = (NoArvoreAVL)temp1.getEsq();
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			if (temp2.getFatorBalanceamento() == 1)
				((NoArvoreAVL)no).setFatorBalanceamento((byte) -1);
			else
				((NoArvoreAVL)no).setFatorBalanceamento((byte) 0);
			if (temp2.getFatorBalanceamento() == -1)
				temp1.setFatorBalanceamento((byte) 1);
			else
				temp1.setFatorBalanceamento((byte) 0);
			no = temp2;
		}
		((NoArvoreAVL)no).setFatorBalanceamento((byte) 0);
		this.h = false;
		return (NoArvoreAVL)no;
	}

	public ArrayList<PessoaBanco> CamPreOrdem() {
		int[] n = new int[1];
		n[0] = 0;
		ArrayList<PessoaBanco> lista = new ArrayList<PessoaBanco>();
		return (FazCamPreOrdem(this.raiz, lista));
	}

	private ArrayList<PessoaBanco> FazCamPreOrdem(NoArvoreABB arv, ArrayList<PessoaBanco> lista) {
		if (arv != null) {
			lista.add(arv.getInfo());
			lista = FazCamPreOrdem(arv.getEsq(), lista);
			lista = FazCamPreOrdem(arv.getDir(), lista);
		}
		return lista;
	}

	@Override
	public String toString() {
		ArrayList<PessoaBanco> pessoas = this.CamPreOrdem();
		String msg = "";
		for (PessoaBanco pessoa : pessoas) {
			msg += pessoa.toString() + "\n\n";
		}

		return msg;
	}

}
