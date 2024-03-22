package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OscarService {
    ArrayList<Indicacao> indicacoes = new ArrayList<>();

    public void adicionarIndicacao(Indicavel indicavel, String categoria){
        if(indicavel.getElegivel()) {
            short numeroDeIndicacoes = indicavel.getNumeroDeIndicacoes();
            short novoNumeroDeIndicacoes = (short) (numeroDeIndicacoes + 1);

            if (numeroDeIndicacoes == 0) {
                indicavel.setNumeroDeIndicacoes(novoNumeroDeIndicacoes);

                Indicacao indicacao = new Indicacao(indicavel, categoria);
                indicacoes.add(indicacao);
            } else{
                for(Indicacao i : indicacoes){
                    if(i.getIndicavel().equals(indicavel)){
                        i.getIndicavel().setNumeroDeIndicacoes(novoNumeroDeIndicacoes);
                    }
                }
            }
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
