package com.example.estoque.service;

import com.example.estoque.exception.NotFoundException;
import com.example.estoque.model.document.PurchaseOrder;
import com.example.estoque.repository.PurchaseOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    // busca todos os produtos no MongoDB e retorna uma lista.
    public List<PurchaseOrder> findAll() {
        return repository.findAll();
    }

    // Busca um ordem de compra pelo id, lança NotFoundException se não encontrado
    public PurchaseOrder findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ordem de compra não encontrada"));
    }

    // Salva uma ordem de compra no banco de dados e retorna o produto salvo
    public PurchaseOrder save(PurchaseOrder purchaseOrder ) {
        return repository.save(purchaseOrder ); //
    }

    // Deleta uma ordem de compra pelo id, retorna a ordem de compra deletado
    public PurchaseOrder delete(String id) {
        PurchaseOrder purchaseOrder  = findById(id); //
        repository.delete(purchaseOrder ); //
        return purchaseOrder ; //
    }
}
