package br.edu.ifpb.chatnoir.model;

import br.edu.ifpb.chatnoir.enums.EstadoCelula;

public class Celula {
    private int linha, coluna; //coordenadas no tabuleiro
    private EstadoCelula estadoCelula;

    public Celula(int linha, int coluna, EstadoCelula estadoCelula){
        this.linha = linha;
        this.coluna = coluna;
        this.estadoCelula = estadoCelula;
    }

    public boolean isEmpty(){
        return false;
    }

    public boolean isBlocked(){
        return false;
    }

    public  boolean hasCat(){
        return false;
    }
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public EstadoCelula getEstadoCelula() {
        return estadoCelula;
    }

    public void setEstadoCelula(EstadoCelula estadoCelula) {
        this.estadoCelula = estadoCelula;
    }
}
