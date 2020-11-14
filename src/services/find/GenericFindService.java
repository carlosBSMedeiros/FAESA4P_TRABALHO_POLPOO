package services.find;

import estruturasDados.FilaPessoa;
import estruturasDados.SuperEstrutura;

public interface GenericFindService { 

	public FilaPessoa find(SuperEstrutura superEstrutura, String stringBusca);
	
}
