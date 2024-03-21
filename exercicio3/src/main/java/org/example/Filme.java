package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Filme implements Indicavel{
    private String nome;
    private String genero;

    public Filme(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
