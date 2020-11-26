package estruturasDados.arvore;

import java.util.ArrayList;

import estruturasDados.FilaPessoa;
import estruturasDados.SuperEstrutura;
import models.PessoaBanco;
import services.find.ArvoreFindService;
import services.sort.ArvoreSortService;
import metodos.Compare;

public class ArvoreAVL extends SuperEstrutura {

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
				no = balancearDir(no, this.h);
				return (NoArvoreAVL) no;
			} else {
//				 Insere � direita e verifica se precisa balancear � esquerda
				no.setDir(this.insere(pessoaBanco, no.getDir()));
				no = balancearEsq(no, this.h);
				return (NoArvoreAVL) no;
			}
		}
	}

	private NoArvoreAVL balancearDir(NoArvore no, boolean h) {
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

	private NoArvoreAVL balancearEsq(NoArvore no, boolean h) {
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
		ArrayList<PessoaBanco> lista = new ArrayList<PessoaBanco>();
		return (this.FazCamInOrdem(this.raiz, lista));
	}

	private ArrayList<PessoaBanco> FazCamInOrdem(NoArvore noArvore, ArrayList<PessoaBanco> lista) {
		if (noArvore != null) {
			lista = this.FazCamInOrdem(noArvore.getEsq(), lista);
			lista.add(noArvore.getInfo());
			lista = this.FazCamInOrdem(noArvore.getDir(), lista);
		}
		return lista;
	}
}