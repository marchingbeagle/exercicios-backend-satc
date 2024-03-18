package org.example;

public class Main {
    public static String retornaIndiceAleatorio(String stringao) {
        // Quebrando o texto em varias strings (colocando dentro de um vetor)
        String[] listaDeNomes = stringao.split("\n");

        // gera um numero aleatorio entre 0 e o tamanho do meu vetor - 1
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        return listaDeNomes[indiceAleatorio];
    }

    public static int geraNumeroAleatorio(int menor, int maior){
        int diferenca = maior - menor + 1;
        int aleatorio = (int) Math.floor(Math.random() * diferenca);
        return aleatorio + menor;
    }

    public static void main(String[] args) throws Exception {
        String urlNomes = "https://venson.net.br/resources/data/nomes.txt";
        String urlClubes = "https://venson.net.br/resources/data/clubes.txt";
        String urlPosicoes = "https://venson.net.br/resources/data/posicoes.txt";
        String urlSobrenomes = "https://venson.net.br/resources/data/sobrenomes.txt";

        GeraListas geraListaNomes = new GeraListas(urlNomes);
        GeraListas geraListaSobrenomes = new GeraListas(urlSobrenomes);
        GeraListas geraListaClubes = new GeraListas(urlClubes);
        GeraListas geraListaPosicoes = new GeraListas(urlPosicoes);

        geraListaNomes.geraLista();
        String listaDeNomes = geraListaNomes.getLista();

        geraListaSobrenomes.geraLista();
        String listaDeSobrenomes = geraListaSobrenomes.getLista();

        geraListaClubes.geraLista();
        String listaDeClubes = geraListaClubes.getLista();

        geraListaPosicoes.geraLista();
        String listaDePosicoes = geraListaPosicoes.getLista();

        String nome = retornaIndiceAleatorio(listaDeNomes);
        String sobrenome = retornaIndiceAleatorio(listaDeSobrenomes);
        String clubes = retornaIndiceAleatorio(listaDeClubes);
        String posicoes = retornaIndiceAleatorio(listaDePosicoes);

        int idade = geraNumeroAleatorio(17,40);

        System.out.printf("%s %s é um futebolista brasileiro de %d anos que atua como %s no time %s", nome, sobrenome, idade, posicoes, clubes);
    }
}