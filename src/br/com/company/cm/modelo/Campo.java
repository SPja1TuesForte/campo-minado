package br.com.company.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	private boolean isAberto = false;
	private boolean isMinado = false;
	private boolean isMarcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	public Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		
		boolean isLinhaDiferente = linha != vizinho.linha;
		boolean isColunaDiferente = linha != vizinho.linha;
		boolean isDiagonal = isLinhaDiferente && isColunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		
		if(deltaGeral == 1 && !isDiagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && isDiagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
	}
	
}
