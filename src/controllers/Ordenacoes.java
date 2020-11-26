package controllers;

import estruturasDados.SuperEstrutura;
import services.sort.GenericSortService;

public class Ordenacoes {

	public static void SortService(SuperEstrutura estrutura, GenericSortService genericSortService) {
		genericSortService.sort(estrutura);
	}
}
