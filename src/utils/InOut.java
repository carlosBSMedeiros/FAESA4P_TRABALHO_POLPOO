package utils;

import java.awt.Color;

import javax.swing.JOptionPane;

/*
 * Classe construida para facilitar a utilização da classe JOptinPane
 * @autor: Carlos Baraquiel Stein de Medeiros, 2020
 * */
public class InOut {

//		Interesting method, check in documentation
//		JOptionPane.showInternalConfirmDialog(null, "test");
	public static void main(String[] args) {
		JOptionPane.getRootFrame().setBackground(Color.BLUE);
	}
	
	public static String inputString(String msg) {
		JOptionPane.getRootFrame().setBackground(Color.BLUE);
		return JOptionPane.showInputDialog(msg);
		
	}
	
	public static Integer inputInteger(String msg) {
		JOptionPane.getRootFrame().setBackground(Color.BLUE);
		return Integer.parseInt(JOptionPane.showInputDialog(msg));
		
	}
	
	public static Double inputDouble(String msg) {
		
		return Double.parseDouble(JOptionPane.showInputDialog(msg));
		
	}
	
	
	public static void outputInformacao(Object conteudo, String titulo) {
			JOptionPane.showMessageDialog(null, conteudo.toString(), titulo, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static void outputError(String conteudo) {
		JOptionPane.showMessageDialog(null, conteudo, "Error", JOptionPane.ERROR_MESSAGE);
	
	}
	
	public static String menuInformacoes(String[] opcoes, String titulo, boolean dropdOpts) {
	
		if(dropdOpts) {
			return (String) JOptionPane.showInputDialog(null, opcoes, titulo, JOptionPane.QUESTION_MESSAGE ,null, opcoes, null);
		} 
		
		return (String) JOptionPane.showInputDialog(null, opcoes, titulo, JOptionPane.QUESTION_MESSAGE ,null, null, null);
		
	}

	
	
	
}
