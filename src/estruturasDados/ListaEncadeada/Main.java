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
		c2.setAgencia("12345");
		c2.setConta("789456");
		c2.setCpf("651465165165165");
		c2.setSaldo("1500");
		
		
		PessoaBanco c3 = new PessoaBanco();
		c3.setNome("gabriel");
		c3.setAgencia("12345");
		c3.setConta("789456");
		c3.setCpf("651465165165165");
		c3.setSaldo("1500");
		
		list.add(new Item(c1),new Item(c2),new Item(c3));
		System.out.println(list.toString());
		

	}

}
