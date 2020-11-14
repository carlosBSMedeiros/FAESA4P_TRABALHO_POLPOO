package controllers;

import estruturasDados.Tabela;
import services.sort.GenericSortService;

public class Ordenacoes {

	public static void SortService(Tabela tabela, GenericSortService tabelaSortService) {
		 tabelaSortService.sort(tabela);
	}
}
