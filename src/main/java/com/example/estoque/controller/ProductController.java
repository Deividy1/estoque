package com.example.estoque.controller;

import com.example.estoque.model.document.Product;
import com.example.estoque.service.ProductService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta classe é um controlador REST e que os métodos retornarão dados diretamente no corpo da resposta
@RequestMapping("/products") // mapeia as requisições para /products
@AllArgsConstructor // Gera um construtor com um parâmetro para cada campo da classe, útil para injeção de dependências
public class ProductController {

    private final ProductService service;

    // Busca todos os produtos e retorna uma lista
    @GetMapping("/{id}")
    public Product findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping // ← sem /{id}
    public List<Product> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable String id) {
        return service.delete(id);
    }

}
