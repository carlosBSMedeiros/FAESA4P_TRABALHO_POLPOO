package services.find;

import java.util.ArrayList;

import estruturasDados.FilaPessoa;
import estruturasDados.SuperEstrutura;
import estruturasDados.arvore.ArvoreABB;
import estruturasDados.arvore.ArvoreAVL;
import estruturasDados.arvore.NoArvore;
import metodos.Compare;
import models.PessoaBanco;

public class ArvoreFindService implements GenericFindService {

	@Override
	public FilaPessoa find(SuperEstrutura superEstrutura, String cpfBusca) {
		if (superEstrutura instanceof ArvoreAVL)
			return find((ArvoreAVL) superEstrutura, cpfBusca);
		else
			return find((ArvoreABB) superEstrutura, cpfBusca);
	}

	private FilaPessoa find(ArvoreABB arvore, String cpfBusca) {

		FilaPessoa fila = new FilaPessoa();

		this.find(cpfBusca, arvore.getRaiz(), fila);

		return fila;
	}

	private FilaPessoa find(ArvoreAVL arvore, String cpfBusca) {

		FilaPessoa fila = new FilaPessoa();

		this.find(cpfBusca, arvore.getRaiz(), fila);

		return fila;
	}

	private NoArvore find(String cpfBusca, NoArvore no, FilaPessoa fila) {
		if (no != null) {
			if (no.getInfo().getCpf().compareTo(cpfBusca) == 0) {
				fila.enfileirar(no.getInfo());
			} else if (cpfBusca.compareTo(no.getInfo().getCpf()) < 0) {
				no = find(cpfBusca, no.getEsq(), fila);
			} else {
				if (cpfBusca.compareTo(no.getInfo().getCpf()) > 0) {
					no = find(cpfBusca, no.getDir(), fila);
				}
			}
		}

		return no;
	}

}
