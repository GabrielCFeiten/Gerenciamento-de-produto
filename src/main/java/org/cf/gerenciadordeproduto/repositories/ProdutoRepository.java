package org.cf.gerenciadordeproduto.repositories;

import org.cf.gerenciadordeproduto.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
