package org.example;

public interface Indicavel {
    Boolean elegivel = false;
    Short numeroDeIndicacoes = 0;

    Boolean getElegivel();
    Short getNumeroDeIndicacoes();
    void setElegivel(Boolean elegivel);
    void setNumeroDeIndicacoes(Short ni);
}