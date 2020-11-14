package controllers;


import estruturasDados.FilaPessoa;
import estruturasDados.Tabela;
import services.find.GenericFindService;

public class Buscas {

	public static FilaPessoa FindService(Tabela tabela, String cpfBusca, GenericFindService tabelaFindService) {
		return tabelaFindService.find(tabela, cpfBusca);
	}
	
}
