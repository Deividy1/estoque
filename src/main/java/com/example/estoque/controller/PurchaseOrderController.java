package com.example.estoque.controller;

import com.example.estoque.model.document.PurchaseOrder;
import com.example.estoque.service.PurchaseOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/purchase-order") // mapeia as requisições para /purchase-order
@RestController // Indica que esta classe é um controlador REST e que os métodos retornarão dados diretamente no corpo da resposta
@AllArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    // Busca um movimento de estoque pelo id, lança NotFoundException se não encontrado
    @GetMapping("/{id}")
    public PurchaseOrder findById(@PathVariable String id) {
        return service.findById(id);
    }

    // Busca todos os movimentos de estoque e retorna uma lista
    @GetMapping
    public List<PurchaseOrder> findAll() {
        return service.findAll();
    }

    @PostMapping
    // mapeia as requisições POST para este método, indicando que ele será usado para criar um novo movimento de estoque
    public PurchaseOrder save(@RequestBody PurchaseOrder purchaseOrder) {
        return service.save(purchaseOrder);
    }

    @DeleteMapping("/{id}") // mapeia as requisições DELETE para este método, indicando que ele será usado para excluir um movimento de estoque existente com base no ID fornecido na URL
    public PurchaseOrder delete(@PathVariable String id) {
        return service.delete(id);
    }
}
