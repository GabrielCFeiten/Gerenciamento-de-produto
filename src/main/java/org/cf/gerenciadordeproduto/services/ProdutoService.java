package org.cf.gerenciadordeproduto.services;

import org.cf.gerenciadordeproduto.models.ProdutoModel;
import org.cf.gerenciadordeproduto.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    public ProdutoModel create(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoModel update(Long id, ProdutoModel produtoModel) {
        Optional<ProdutoModel> produtoBuscado = produtoRepository.findById(id);

        if (produtoBuscado.isPresent()) {
            ProdutoModel produto = produtoBuscado.get();

            produto.setNomeProduto(produtoModel.getNomeProduto());
            produto.setPrecoProduto(produtoModel.getPrecoProduto());
            produto.setEstoque(produtoModel.getEstoque());

            return produtoRepository.save(produto);
        }

        return null;
    }

    public ProdutoModel findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

}
