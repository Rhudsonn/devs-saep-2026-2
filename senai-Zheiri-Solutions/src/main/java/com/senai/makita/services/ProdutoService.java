package com.senai.makita.services;

import com.senai.makita.repositorys.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {


    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


}
