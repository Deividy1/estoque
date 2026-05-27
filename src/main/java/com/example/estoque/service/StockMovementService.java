package com.example.estoque.service;

import com.example.estoque.exception.NotFoundException;
import com.example.estoque.model.document.StockMovement;
import com.example.estoque.repository.StockMovementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StockMovementService {

    private final StockMovementRepository repository;

    // busca todos os produtos no MongoDB e retorna uma lista.
    public List<StockMovement> findAll() {
        return repository.findAll();
    }

    // Busca um produto pelo id, lança NotFoundException se não encontrado
    public StockMovement findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Movimento de estoque não encontrado"));
    }

    // Salva um produto no banco de dados e retorna o produto salvo
    public StockMovement save(StockMovement stockMovement ) {
        return repository.save(stockMovement ); //
    }

    // Deleta um produto pelo id, retorna o produto deletado
    public StockMovement delete(String id) {
        StockMovement stockMovement  = findById(id); //
        repository.delete(stockMovement ); //
        return stockMovement ; //
    }
}
