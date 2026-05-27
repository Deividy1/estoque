package com.example.estoque.controller;

import com.example.estoque.model.document.Supplier;
import com.example.estoque.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/suppliers") // mapeia as requisições para /suppliers
@RestController // Indica que esta classe é um controlador REST e que os métodos retornarão dados diretamente no corpo da resposta
@AllArgsConstructor // Gera um construtor com um parâmetro para cada campo da classe, útil para injeção de dependências
public class SupplierController {

    private final SupplierService service;

    // Busca todos os produtos e retorna uma lista
    @GetMapping("/{id}")
    public Supplier findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping // ← sem /{id}
    public List<Supplier> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Supplier save(@RequestBody Supplier supplier) {
        return service.save(supplier);
    }

    @DeleteMapping("/{id}")
    public Supplier delete(@PathVariable String id) {
        return service.delete(id);
    }
}
