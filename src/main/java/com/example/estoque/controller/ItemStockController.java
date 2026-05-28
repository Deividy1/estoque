package com.example.estoque.controller;

import com.example.estoque.dto.ItemStockDTO;
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
    public ItemStockDTO findById(@PathVariable String id) {
        return ItemStockDTO.fromEntity(service.findById(id));
    }

    @GetMapping // ← sem /{id}
    public List<ItemStockDTO> findAll() {
        return service.findAll().stream()
                .map(ItemStockDTO::fromEntity)
                .toList();
    }

    @PostMapping
    public ItemStockDTO save(@RequestBody ItemStock itemStock) {
        return ItemStockDTO.fromEntity(service.save(itemStock));
    }

    @DeleteMapping("/{id}")
    public ItemStockDTO delete(@PathVariable String id) {
        return ItemStockDTO.fromEntity(service.delete(id));
    }
}
