package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Bean
    public Ator atorBean(){
        return new Ator("John Doe", "USA", (short) 0, false);
    }

    @Bean
    public OscarService oscarService() {
        return new OscarService();
    }
}
