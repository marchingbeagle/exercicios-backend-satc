package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Ator ator1 = context.getBean(Ator.class);
        ator1.setNome("Erik");
        ator1.setNacionalidade("Brasileiro");
        ator1.setNumeroDeIndicacoes((short) 0);
        ator1.setElegivel(true);

        Filme filme1 = context.getBean(Filme.class);
        filme1.setNome("Avengers");
        filme1.setGenero("Ação");
        filme1.setNumeroDeIndicacoes((short) 0);
        filme1.setElegivel(true);

        OscarService oscarService = context.getBean(OscarService.class);
        oscarService.adicionarIndicacao(ator1, "Ator");
        oscarService.adicionarIndicacao(ator1, "Ator");

        oscarService.adicionarIndicacao(filme1, "Filme");
        oscarService.adicionarIndicacao(filme1, "Filme");
        oscarService.adicionarIndicacao(filme1, "Filme");
        oscarService.mostrarListaDeIndicados();
    }
}
