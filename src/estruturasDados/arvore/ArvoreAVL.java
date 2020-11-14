package estruturasDados.arvore;

import java.util.ArrayList;

import estruturasDados.FilaPessoa;
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

	private NoArvoreAVL insere(PessoaBanco pessoaBanco, NoArvore no) {
		if (no == null) {
			NoArvoreAVL novo = new NoArvoreAVL(pessoaBanco);
			this.h = true;
			return novo;
		} else {
			if (Compare.pessoa(pessoaBanco, no.getInfo()) < 0) {
				// Insere � esquerda e verifica se precisa balancear � direita
				no.setEsq(this.insere(pessoaBanco, no.getEsq()));
				no = this.balancearDir(no);
				return (NoArvoreAVL) no;
			} else {
//				 Insere � direita e verifica se precisa balancear � esquerda
				no.setDir(this.insere(pessoaBanco, no.getDir()));
				no = this.balancearEsq(no);
				return (NoArvoreAVL) no;
			}
		}
	}

	private NoArvoreAVL balancearDir(NoArvore no) {
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

	private NoArvoreAVL balancearEsq(NoArvore no) {
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

	private NoArvoreAVL rotacaoDireita(NoArvore no) {
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
		this.h = false;
		return (NoArvoreAVL) no;
	}

	private NoArvoreAVL rotacaoEsquerda(NoArvore no) {
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
		this.h = false;
		return (NoArvoreAVL) no;
	}

	public ArrayList<PessoaBanco> CamPreOrdem() {
		ArrayList<PessoaBanco> lista = new ArrayList<PessoaBanco>();
		return (FazCamPreOrdem(this.raiz, lista));
	}

	private ArrayList<PessoaBanco> FazCamPreOrdem(NoArvore arv, ArrayList<PessoaBanco> lista) {
		if (arv != null) {
			lista.add(arv.getInfo());
			lista = FazCamPreOrdem(arv.getEsq(), lista);
			lista = FazCamPreOrdem(arv.getDir(), lista);
		}
		return lista;
	}

	public NoArvore Pesquisar(NoArvore no, String search) {
		if (no != null) {
			if (search.compareTo(no.getInfo().getCpf()) < 0) {
				no =  Pesquisar(no.getEsq(), search);
			} else {
				if(search.compareTo(no.getInfo().getCpf()) > 0) {
					no = Pesquisar(no.getDir(), search);	
				}
			}
		}
		
		return no;
	}
	
	public NoArvore Pesquisar(NoArvore no, String search, FilaPessoa fila) {
		if (no != null) {
			if (no.getInfo().getCpf().compareTo(search) == 0) {
				fila.enfileirar(no.getInfo());
			} else if (search.compareTo(no.getInfo().getCpf()) < 0) {
				no = Pesquisar(no.getEsq(), search, fila);
			} else {
				if (search.compareTo(no.getInfo().getCpf()) > 0) {
					no = Pesquisar(no.getDir(), search, fila);
				}
			}
		}

		return no;
	}

	public FilaPessoa pesquisaFilaPessoa(String search) {
		FilaPessoa fila = new FilaPessoa();

		Pesquisar(this.raiz, search, fila);

		return fila;
	}

	public ArrayList<PessoaBanco> InOrdem() {
		ArrayList<PessoaBanco> pesssoasBanco = new ArrayList<PessoaBanco>();
		return (FazCamInOrdem(this.raiz, pesssoasBanco));
	}

	private ArrayList<PessoaBanco> FazCamInOrdem(NoArvore no, ArrayList<PessoaBanco> lista) {
		if (no != null) {
			lista.add(no.getInfo());
			lista = FazCamInOrdem(no.getEsq(), lista);
			lista = FazCamInOrdem(no.getDir(), lista);
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