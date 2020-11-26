package controllers;


import estruturasDados.FilaPessoa;
import estruturasDados.SuperEstrutura;
import estruturasDados.Tabela;
import services.find.GenericFindService;

public class Buscas {

	public static FilaPessoa FindService(SuperEstrutura estrutura, String cpfBusca, GenericFindService tabelaFindService) {
		return tabelaFindService.find(estrutura, cpfBusca);
	}
	
}
