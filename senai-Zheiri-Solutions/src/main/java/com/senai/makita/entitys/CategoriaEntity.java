package com.senai.makita.entitys;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    //@Column(nullable = false, unique = true)
    //private String nome;


    //@OneToMany(mappedBy = "categoria")
    //private List<ProdutoEntity> produtos;


}
