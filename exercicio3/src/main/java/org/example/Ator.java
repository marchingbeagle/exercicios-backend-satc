package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ator implements Indicavel{
    private String nome;
    private String nacionalidade;
    private Short numeroDeIndicacoes = 0;
    private Boolean elegivel = false;

    @Autowired
    public Ator(String nome, String nacionalidade, Short numeroDeIndicacoes, Boolean elegivel) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.numeroDeIndicacoes = numeroDeIndicacoes;
        this.elegivel = elegivel;
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

    @Override
    public String toString() {
        return "Nome: " + this.nome + " || " + "Indicações: " + this.numeroDeIndicacoes + " || ";
    }
}
