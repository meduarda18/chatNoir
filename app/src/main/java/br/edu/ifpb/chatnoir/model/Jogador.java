package br.edu.ifpb.chatnoir.model;

import br.edu.ifpb.chatnoir.enums.TipoJogador;

public class Jogador {
    private TipoJogador tipoJogador;
    private int vitorias;

    public Jogador(TipoJogador tipoJogador, int vitorias){
        this.tipoJogador = tipoJogador;
        this.vitorias = Math.max(0, vitorias);
    }

    public TipoJogador getTipoJogador() {
        return tipoJogador;
    }

    public void setTipoJogador(TipoJogador tipoJogador) {
        this.tipoJogador = tipoJogador;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void incrementarVitorias() {
        this.vitorias++;
    }

    public void resetarVitorias() {
        this.vitorias = 0;
    }
}
