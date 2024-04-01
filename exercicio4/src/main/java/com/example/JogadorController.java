package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {
    @RequestMapping(value="/criarjogador", method = RequestMethod.GET)
    public Jogador Jogador(){
        GeradorJogador geradorJogador = new GeradorJogador();
        Jogador jogador = geradorJogador.geraJogador();
        return jogador;
    }
}
