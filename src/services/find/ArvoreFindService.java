package services.find;

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
		NoArvore noTemp = no;
		
		if (noTemp != null) {
			if (cpfBusca.compareTo(no.getInfo().getCpf()) < 0) {
				noTemp = this.find(cpfBusca, noTemp.getEsq());
			} else {
				if (cpfBusca.compareTo(no.getInfo().getCpf()) > 0) {
					noTemp = this.find(cpfBusca, noTemp.getDir());
				}
			}
		}
		return noTemp;
	}

}
