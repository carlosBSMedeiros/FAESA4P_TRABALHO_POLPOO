package controllers;

import estruturasDados.Tabela;
import services.sort.TabelaSortService;

public class Sort {

	public static void SortService(Tabela tabela, TabelaSortService tabelaSortService) {
		 tabelaSortService.sort(tabela);
	}
}
