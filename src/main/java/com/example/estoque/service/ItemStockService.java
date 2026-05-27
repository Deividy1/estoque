package com.example.estoque.service;

import com.example.estoque.exception.NotFoundException;
import com.example.estoque.model.document.ItemStock;
import com.example.estoque.repository.ItemStockRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ItemStockService {

    private final ItemStockRepository repository;

    // busca todos os produtos no MongoDB e retorna uma lista.
    public List<ItemStock> findAll() {
        return repository.findAll();
    }

    // Busca um produto pelo id, lança NotFoundException se não encontrado
    public ItemStock findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item de estoque não encontrado"));
    }

    // Salva um produto no banco de dados e retorna o produto salvo
    public ItemStock save(ItemStock itemStock ) {
        return repository.save(itemStock ); //
    }

    public ItemStock delete(String id) {
        ItemStock itemStock  = findById(id); // busca o produto para garantir que existe
        repository.delete(itemStock ); // deleta o produto do banco de dados
        return itemStock ; // retorna o produto deletado
    }
}
