package com.example.estoque.controller;

import com.example.estoque.dto.SupplierDTO;
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
    public SupplierDTO findById(@PathVariable String id) {
        return SupplierDTO.fromSupplier(service.findById(id));
    }

    @GetMapping // ← sem /{id}
    public List<SupplierDTO> findAll() {
        return service.findAll().stream()
                .map(SupplierDTO::fromSupplier)
                .toList();
    }

    @PostMapping
    public SupplierDTO save(@RequestBody Supplier supplier) {
        return SupplierDTO.fromSupplier(service.save(supplier));
    }

    @DeleteMapping("/{id}")
    public SupplierDTO delete(@PathVariable String id) {
        return SupplierDTO.fromSupplier(service.delete(id));
    }
}
