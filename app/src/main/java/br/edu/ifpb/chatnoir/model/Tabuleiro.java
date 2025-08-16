package br.edu.ifpb.chatnoir.model;

import br.edu.ifpb.chatnoir.enums.EstadoCelula;

public class Tabuleiro {
    private int tamanho = 11;
    private final Celula[][] celulas;
    private final int linhaGato, colunaGato;

    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;
        this.celulas = new Celula[tamanho][tamanho];

        for(int l = 0; l < tamanho; l++){
            for(int c = 0; c < tamanho; c++){
                celulas[l][c] = new Celula(l, c, EstadoCelula.VAZIA);
            }
        }

        this.linhaGato = tamanho/2;
        this.colunaGato = tamanho/2;
        getCelula(linhaGato, colunaGato).setEstadoCelula(EstadoCelula.GATO);
    }

    public int getTamanho() {
        return tamanho;
    }

    public Celula getCelula(int linha, int coluna) {
        checarLimites(linha, coluna);
        return celulas[linha][coluna];
    }

    public int getLinhaGato() {
        return linhaGato;
    }

    public int getColunaGato() {
        return colunaGato;
    }

    private boolean estaDentro(int linha, int coluna) {
        return linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho;
    }

    private void checarLimites(int linha, int coluna) {
        if (!estaDentro(linha, coluna)) {
            throw new IndexOutOfBoundsException("Fora do tabuleiro: (" + linha + "," + coluna + ")");
        }
    }
}
