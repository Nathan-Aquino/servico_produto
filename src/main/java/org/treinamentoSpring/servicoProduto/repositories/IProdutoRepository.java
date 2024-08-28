package org.treinamentoSpring.servicoProduto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.treinamentoSpring.servicoProduto.entities.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Integer>{
    List<Produto> findAll();

    Optional<Produto> findById(Integer id);
}
