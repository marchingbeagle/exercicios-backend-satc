package com.example.controller;

import com.example.model.cliente.Cliente;
import com.example.model.cliente.ClienteDTO;
import com.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class controller {
    @Autowired
    ClienteRepository repository;

    @GetMapping("/cliente/{nome}")
    public ClienteDTO retornaCliente(@PathVariable String nome){
        Cliente cliente = repository.findByName(nome);
        return new ClienteDTO(cliente.getNome(), cliente.getSaldo());
    }

    @PostMapping("/cliente")
    public ResponseEntity<?> criaCliente(@RequestBody Cliente cliente){
        repository.save(cliente);
        return ResponseEntity.ok(cliente);
    }
}
