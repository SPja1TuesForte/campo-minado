package br.com.company.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {
	
	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		
		gerarCampos();
		associarOsVizinhos();
		sortearAsMinas();
	}	

	
	public void abrir(int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha() == linhas && c.getColuna() == colunas).findFirst().ifPresent(c -> c.abrir());
	}
	
	public void alternarMarcacao(int linha, int coluna) {
		campos.parallelStream().filter(c -> c.getLinha() == linhas && c.getColuna() == colunas).findFirst().ifPresent(c -> c.alternarMarcacao());
	}
	
	private void gerarCampos() {
		for(int l = 0; l <linhas; l++) {
			for (int c = 0; c < colunas; c++) {
				campos.add(new Campo(l, c));
			}
		}
	}
	
	private void associarOsVizinhos() {
		for(Campo c1: campos) {
			for(Campo c2: campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}

	private void sortearAsMinas() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		
		do {
			minasArmadas = campos.stream().filter(minado).count();
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
		} while(minasArmadas < minas);
	}
	
	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}
	
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearAsMinas();
	}
	
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();
		int i = 0;
		
		for (int l = 0; l < linhas; l++) {
			for (int c = 0; c < colunas; c++) {
				stringBuilder.append(" ");
				stringBuilder.append(campos.get(i));
				stringBuilder.append(" ");
				i++;
			}
			stringBuilder.append("\n");
		}
		
		
		return stringBuilder.toString();
	}
}
