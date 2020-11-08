package services.find;

import estruturasDados.FilaPessoa;
import estruturasDados.Tabela;

public interface TabelaFindService {

	public FilaPessoa find(Tabela tabela, String stringBusca);
	
}
