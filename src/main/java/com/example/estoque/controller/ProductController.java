package com.example.estoque.controller;

import com.example.estoque.dto.ProductDTO;
import com.example.estoque.model.document.Product;
import com.example.estoque.service.ProductService;
import jakarta.validation.Valid;
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
    public ProductDTO findById(@PathVariable String id) {
        return ProductDTO.fromProduct(service.findById(id));
    }

    @GetMapping // ← sem /{id}
    public List<ProductDTO> findAll() {
        return service.findAll().stream()
                .map(ProductDTO::fromProduct)
                .toList();
    }

    @PostMapping
    public ProductDTO save(@Valid @RequestBody Product product) {
        return ProductDTO.fromProduct(service.save(product));
    }

    @DeleteMapping("/{id}")
    public ProductDTO delete(@PathVariable String id) {
        return ProductDTO.fromProduct(service.delete(id));
    }

}
