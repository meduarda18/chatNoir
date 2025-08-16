package br.edu.ifpb.chatnoir.model;

public class GatoIA {
    private int linha, coluna;

    public GatoIA(){
        this.linha = 5;
        this.coluna = 5;
    }

    public boolean escapou(Tabuleiro tabuleiro) {
        return linha == 0 || linha == tabuleiro.getTamanho() - 1 ||
                coluna == 0 || coluna == tabuleiro.getTamanho() - 1;
    }

    public boolean foiCercado(Tabuleiro tabuleiro) {
        //return movimentosPossiveis(tabuleiro).isEmpty(); implementar esse método
        return false;
    }
}
