package org.example;

public class Jogador {
    String nome =  "Jogador Padrao";
    int posicaoX = 0;
    int posicaoY = 0;

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", posicaoX=" + posicaoX +
                ", posicaoY=" + posicaoY +
                '}';
    }

    public void mover(int x, int y){
       posicaoX = x;
       posicaoY = y;
    }
}
