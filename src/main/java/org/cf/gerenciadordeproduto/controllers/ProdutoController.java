package org.cf.gerenciadordeproduto.controllers;

import org.cf.gerenciadordeproduto.models.ProdutoModel;
import org.cf.gerenciadordeproduto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> create(@RequestBody ProdutoModel produto){
        ProdutoModel request = produtoService.create(produto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> update(@PathVariable Long id, @RequestBody ProdutoModel produto){
        ProdutoModel request = produtoService.update(id, produto);
        return ResponseEntity.ok().body(request);
    }
}
