package estruturasDados.ListaEncadeada;

import models.PessoaBanco;

public class Main {
	public static void main(String[] args) {
		ListaSimples list = new ListaSimples();
		PessoaBanco c1 = new PessoaBanco();
		c1.setNome("breno");
		c1.setAgencia("12345");
		c1.setConta("789456");
		c1.setCpf("651465165165165");
		c1.setSaldo("1500");
		
		PessoaBanco c2 = new PessoaBanco();
		c2.setNome("fabio");
		c2.setAgencia("65465");
		c2.setConta("789456");
		c2.setCpf("651465165165165");
		c2.setSaldo("1500");
		
		
		PessoaBanco c3 = new PessoaBanco();
		c3.setNome("gabriel");
		c3.setAgencia("1203654345");
		c3.setConta("789456");
		c3.setCpf("651465165165165");
		c3.setSaldo("1500");
		
		PessoaBanco c4 = new PessoaBanco();
		c4.setNome("wes");
		c4.setAgencia("88888");
		c4.setConta("789456");
		c4.setCpf("651465165165165");
		c4.setSaldo("1500");
		
		list.add(new Item(c1),new Item(c2),new Item(c3));
		System.out.println(list.toString());
		
		System.out.println("pesq");
		System.out.println(list.pesInfo(c2).getInfo().getChave().toString());
		
		System.out.println("add k");
		list.addKesimo(2, new Item(c4));
		
		System.out.println(list.toString());
		System.out.println("remove k");
		list.removeKesima(c3);
		System.out.println(list.toString());
		list.removeKesima(c2);
		System.out.println(list.toString());

	}

}
