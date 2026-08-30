package com.senai.makita.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false)
    //private String nome;

    //@Column(nullable = false)
    //private String caracteristica;

    //@Column(nullable = false)
    //private int tamanho;

    //@Column(nullable = false)
    //private double peso;

    //@Column(nullable = false)
    //private int codigo;

    //@Enumerated(EnumType.STRING)
    //private Status status;

    //@ManyToMany
    //@JoinColumn(name = "produto_id", nullable = false)
    //private CategoriaEntity categoria;



}
