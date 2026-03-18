package com.atividade.java.services;

import com.atividade.java.models.ProdutoModel;
import com.atividade.java.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;
    
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    
    public ProdutoModel salvar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }
    
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }
    
    public Optional<ProdutoModel> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
    
}
