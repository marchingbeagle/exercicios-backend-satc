package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OscarService {
    ArrayList<Indicacao> indicacoes = new ArrayList<>();

    public void adicionarIndicacao(Indicavel indicavel, String categoria){
        if(indicavel.getElegivel()) {
            Short numeroDeIndicacoes = indicavel.getNumeroDeIndicacoes();
            short novoNumeroDeIndicacoes = (short) (numeroDeIndicacoes + 1);
            indicavel.setNumeroDeIndicacoes(novoNumeroDeIndicacoes);

            Indicacao indicacao = new Indicacao(indicavel, categoria);
            indicacoes.add(indicacao);
        } else{
            System.out.printf("Nao pode ser indicado");
        }
    }

    public void mostrarListaDeIndicados(){
        for (Indicacao item : this.indicacoes) {
            System.out.println(item);
        }
    }
}
