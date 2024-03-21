package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ator implements Indicavel{
    private String nome;
    private String nacionalidade;

    public Ator(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public void setElegivel(Boolean e){
    }

    @Override
    public Boolean getElegivel(){
        return elegivel;
    }

    @Override
    public void setNumeroDeIndicacoes(Short ni){
    }

    @Override
    public Short getNumeroDeIndicacoes(){
        return numeroDeIndicacoes;
    }
}
