package org.treinamentoSpring.servicoProduto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.treinamentoSpring.servicoProduto.entities.Produto;
import org.treinamentoSpring.servicoProduto.repositories.IProdutoRepository;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    public IProdutoRepository produtos;

    @GetMapping
    public List<Produto> retornaProdutos () {
        return produtos.findAll();
    }

    @GetMapping("/{id}")
    public Produto retornaProduto (@PathVariable Integer id) {
        return produtos.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastraProduto (@RequestBody Produto produto) {
        return produtos.save(produto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizaProduto (@PathVariable Integer id, @RequestBody Produto produto) {
        Optional<Produto> produtoEncontrado = produtos.findById(id);
        
        if (produtoEncontrado.isPresent()) {
            produto.setId(produtoEncontrado.get().getId());
            produtos.save(produto);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
    }
}
