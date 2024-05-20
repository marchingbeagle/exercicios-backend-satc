package com.example.repository;

import com.example.model.cliente.Cliente;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ClienteRepository {
    private Map<String, Cliente> clienteMap = new HashMap<>();

    public Cliente save(Cliente cliente) {
        clienteMap.put(cliente.getNome(), cliente);
        return cliente;
    }

    public Cliente findByName(String nome) {
        return clienteMap.get(nome);
    }

    public Map<String, Cliente> findAll() {
        return clienteMap;
    }

    public void deleteByName(String nome) {
        clienteMap.remove(nome);
    }
}
