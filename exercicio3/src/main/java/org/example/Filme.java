package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Filme implements Indicavel{
    private String nome;
    private String genero;
    private Short numeroDeIndicacoes = 0;
    private Boolean elegivel = false;

    @Autowired
    public Filme(String nome, String genero, Short numeroDeIndicacoes, Boolean elegivel) {
        this.nome = nome;
        this.genero = genero;
        this.numeroDeIndicacoes = numeroDeIndicacoes;
        this.elegivel = elegivel;
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
    public Short getNumeroDeIndicacoes() {
        return numeroDeIndicacoes;
    }

    @Override
    public void setNumeroDeIndicacoes(Short numeroDeIndicacoes) {
        this.numeroDeIndicacoes = numeroDeIndicacoes;
    }

    @Override
    public Boolean getElegivel() {
        return elegivel;
    }

    @Override
    public void setElegivel(Boolean elegivel) {
        this.elegivel = elegivel;
    }
}
