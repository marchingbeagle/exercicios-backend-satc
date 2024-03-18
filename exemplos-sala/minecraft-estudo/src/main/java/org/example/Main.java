package org.example;

public class Main{
    public static void main(String[] args){
        Bloco bloco1 = new Bloco();
        System.out.println(bloco1.nome);

        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        jogador1.mover(1,2);
        System.out.println(jogador1.toString());
    }
}
