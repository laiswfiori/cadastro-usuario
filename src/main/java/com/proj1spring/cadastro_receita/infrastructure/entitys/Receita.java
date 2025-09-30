package com.proj1spring.cadastro_receita.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(length = 1000)
    private String ingredientes;

    @Column(length = 2000)
    private String modoPreparo;

    private String categoria; // Ex: sobremesa, prato principal etc.
}
