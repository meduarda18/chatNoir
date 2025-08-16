package br.edu.ifpb.chatnoir.model;

import java.util.Random;

import br.edu.ifpb.chatnoir.enums.EstadoCelula;

public class Tabuleiro {
    private int tamanho = 11;
    private final Celula[][] celulas;

    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;
        this.celulas = new Celula[tamanho][tamanho];
        inicializarTabuleiro();
        posicionarGato();
        bloquearAleatorias(9);
    }

    public int getTamanho() {
        return tamanho;
    }

    public Celula getCelula(int linha, int coluna) {
        checarLimites(linha, coluna);
        return celulas[linha][coluna];
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                celulas[i][j] = new Celula(i, j, EstadoCelula.VAZIA);
            }
        }
    }

    private void posicionarGato() {
        int centro = tamanho / 2;
        celulas[centro][centro].setEstadoCelula(EstadoCelula.GATO);
        Celula gato = celulas[centro][centro];
    }

    private void bloquearAleatorias(int qnt){
        Random random = new Random();
        int bloqueadas = 0;
        while (bloqueadas < qnt){
            int linha = random.nextInt(tamanho);
            int coluna = random.nextInt(tamanho);

            Celula celula = celulas[linha][coluna];

            if(celula.getEstadoCelula() == EstadoCelula.VAZIA){
                celula.setEstadoCelula(EstadoCelula.BLOQUEADA);
                bloqueadas++;
            }
        }
    }

    public void bloquearCelula(int linha, int coluna) {
        Celula alvo = celulas[linha][coluna];

        if (alvo.getEstadoCelula() == EstadoCelula.VAZIA) {
            alvo.setEstadoCelula(EstadoCelula.BLOQUEADA);
        }
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
