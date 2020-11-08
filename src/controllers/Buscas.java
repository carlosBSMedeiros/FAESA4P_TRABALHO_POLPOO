package controllers;


import estruturasDados.FilaPessoa;
import estruturasDados.Tabela;
import services.find.TabelaFindService;

public class Buscas {

	public static FilaPessoa FindService(Tabela tabela, String cpfBusca, TabelaFindService tabelaFindService) {
		return tabelaFindService.find(tabela, cpfBusca);
	}
	
}
