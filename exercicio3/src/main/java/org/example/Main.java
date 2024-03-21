package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Ator ator1 = context.getBean(Ator.class,"Erik", "Brasileiro");

        OscarService oscarService = context.getBean(OscarService.class);
        oscarService.adicionarIndicacao(ator1, "Ator");
    }
}
