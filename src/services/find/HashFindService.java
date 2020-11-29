package services.find;

import estruturaDados.Hash.Hash;
import estruturaDados.Hash.NoHash;
import estruturasDados.FilaPessoa;
import estruturasDados.SuperEstrutura;
import estruturasDados.ListaEncadeada.No;

public class HashFindService implements GenericFindService {

	@Override
	public FilaPessoa find(SuperEstrutura superEstrutura, String cpfBusca) {
		return find((Hash) superEstrutura, cpfBusca);
	}

	private FilaPessoa find(Hash hash, String cpfBusca) {
		FilaPessoa fila = new FilaPessoa();
		int index = hash.hashing(cpfBusca);

		NoHash nos = hash.getHashEncadeado()[index];
		if(nos != null) {
			No atual = nos.getInfos().getPrim();

			while (atual != null) {

				if (atual.getInfo().getCpf().compareTo(cpfBusca) == 0) {
					fila.enfileirar(atual.getInfo());
				}

				atual = atual.getProx();
			}
		}
		
	
		return fila;
	}

}