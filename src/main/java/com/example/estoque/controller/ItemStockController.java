package com.example.estoque.controller;

import com.example.estoque.model.document.ItemStock;
import com.example.estoque.service.ItemStockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/item-stock")
@RestController
@AllArgsConstructor
public class ItemStockController {

    private final ItemStockService service;

    // Busca todos os produtos e retorna uma lista
    @GetMapping("/{id}")
    public ItemStock findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping // ← sem /{id}
    public List<ItemStock> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ItemStock save(@RequestBody ItemStock itemStock) {
        return service.save(itemStock);
    }

    @DeleteMapping("/{id}")
    public ItemStock delete(@PathVariable String id) {
        return service.delete(id);
    }
}
