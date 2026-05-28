package com.example.estoque.controller;

import com.example.estoque.dto.PurchaseOrderDTO;
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
    public PurchaseOrderDTO findById(@PathVariable String id) {
        return PurchaseOrderDTO.fromPurchaseOrder(service.findById(id));
    }

    // Busca todos os movimentos de estoque e retorna uma lista
    @GetMapping
    public List<PurchaseOrderDTO> findAll() {
        return service.findAll().stream()
                .map(PurchaseOrderDTO::fromPurchaseOrder)
                .toList();
    }

    @PostMapping
    // mapeia as requisições POST para este método, indicando que ele será usado para criar um novo movimento de estoque
    public PurchaseOrderDTO save(@RequestBody PurchaseOrder purchaseOrder) {
        return PurchaseOrderDTO.fromPurchaseOrder(service.save(purchaseOrder));
    }

    @DeleteMapping("/{id}") // mapeia as requisições DELETE para este método, indicando que ele será usado para excluir um movimento de estoque existente com base no ID fornecido na URL
    public PurchaseOrderDTO delete(@PathVariable String id) {
        return PurchaseOrderDTO.fromPurchaseOrder(service.delete(id));
    }
}
