package com.example.estoque.service;

import com.example.estoque.exception.NotFoundException;
import com.example.estoque.model.document.Product;
import com.example.estoque.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    // busca todos os produtos no MongoDB e retorna uma lista.
    public List<Product> findAll() {
        return repository.findAll();
    }

    // Busca um produto pelo id, lança NotFoundException se não encontrado
    public Product findById(String id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    // Salva um produto no banco de dados e retorna o produto salvo
    public Product save(Product product) {
        return repository.save(product); //
    }

    public Product delete(String id) {
        Product product = findById(id); // busca o produto para garantir que existe
        repository.delete(product); // deleta o produto do banco de dados
        return product; // retorna o produto deletado
    }
}
