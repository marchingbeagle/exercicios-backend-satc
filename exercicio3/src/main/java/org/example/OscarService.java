package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OscarService {
    ArrayList<Indicacao> indicacoes = new ArrayList<>();
    public void adicionarIndicacao(Indicavel indicavel, String categoria){
        if(indicavel.getElegivel()){
            Indicacao indicacao = new Indicacao(indicavel, categoria);
            indicacoes.add(indicacao);
        } else{
            System.out.printf("Nao pode ser indicado");
        }
    }

    public void mostrarListaDeIndicados(){
        System.out.println(indicacoes);
    }
}
