package br.com.company.cm;

import br.com.company.cm.modelo.Tabuleiro;

public class Programa {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
	
		tabuleiro.alternarMarcacao(4, 4); 
		tabuleiro.alternarMarcacao(4, 5);
		tabuleiro.abrir(3, 3);
	
		System.out.println(tabuleiro);
	}
}
