package br.edu.ifpb.chatnoir.model;

import java.util.Objects;

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
        return estadoCelula == EstadoCelula.VAZIA;
    }

    public boolean isBlocked(){
        return estadoCelula == EstadoCelula.BLOQUEADA;
    }

    public  boolean hasCat(){
        return estadoCelula == EstadoCelula.GATO;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public EstadoCelula getEstadoCelula() {
        return estadoCelula;
    }

    public void setEstadoCelula(EstadoCelula estadoCelula) {
        this.estadoCelula = Objects.requireNonNull(estadoCelula);
    }
}
