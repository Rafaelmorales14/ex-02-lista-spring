package com.atividade.java.controllers;

import com.atividade.java.models.ProdutoModel;
import com.atividade.java.services.ProdutoService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> salvar(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel request = produtoService.salvar(produtoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoModel.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> request = produtoService.findAll();

        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> findById(@PathVariable Long id) {
        ProdutoModel request = produtoService.findById(id);

        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        produtoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
