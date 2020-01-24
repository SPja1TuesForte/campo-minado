package br.com.company.cm;

import br.com.company.cm.modelo.Tabuleiro;
import br.com.company.cm.visao.TabuleiroConsole;

public class Programa {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		new TabuleiroConsole(tabuleiro);

	}
}
