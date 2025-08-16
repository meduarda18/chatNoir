package br.edu.ifpb.chatnoir.model;

import br.edu.ifpb.chatnoir.enums.TipoJogador;
import br.edu.ifpb.chatnoir.enums.VezJogador;

public class Partida {
    private Tabuleiro tabuleiro;
    private Jogador jogador;
    private GatoIA gato;
    private VezJogador vez;

    public Partida(){
        this.tabuleiro = new Tabuleiro(11);
        this.jogador = new Jogador(TipoJogador.JOGADOR, 0);
        this.gato = new GatoIA();
        this.vez = VezJogador.VEZ_JOGADOR;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public GatoIA getGato() {
        return gato;
    }

    public VezJogador getVez() {
        return vez;
    }

    public void jogadaJogador(int linha, int coluna){
        if(vez == VezJogador.VEZ_JOGADOR){
            jogador.jogar(tabuleiro, linha, coluna);
            vez = VezJogador.VEZ_GATO;
        }
    }

    public void jogadaGato(){}

    public boolean terminou(){
        return gato.escapou(tabuleiro) || gato.foiCercado(tabuleiro);
    }

    public  TipoJogador getVencedor(){
        if(!terminou()){
            return null;
        }
        if(gato.escapou(tabuleiro)){
            return TipoJogador.GATO;
        } else {
            return TipoJogador.JOGADOR;
        }
    }
}
