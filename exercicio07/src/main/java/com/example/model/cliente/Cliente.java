package com.example.model.cliente;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String nome;
    private Double saldo;
    private String senha;
}
