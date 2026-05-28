package com.example.estoque.controller;

import com.example.estoque.dto.StockMovementDTO;
import com.example.estoque.model.document.StockMovement;
import com.example.estoque.service.StockMovementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stock-movement") // mapeia as requisições para /stock-movement
@RestController // Indica que esta classe é um controlador REST e que os métodos retornarão dados diretamente no corpo da resposta
@AllArgsConstructor
public class StockMovementController {

    private final StockMovementService service;

    // Busca um movimento de estoque pelo id, lança NotFoundException se não encontrado
    @GetMapping("/{id}")
    public StockMovementDTO findById(@PathVariable String id) {
        return StockMovementDTO.fromEntity(service.findById(id));
    }

    // Busca todos os movimentos de estoque e retorna uma lista
    @GetMapping
    public List<StockMovementDTO> findAll() {
        return service.findAll()
                .stream()
                .map(StockMovementDTO::fromEntity)
                .toList();
    }

    @PostMapping // mapeia as requisições POST para este método, indicando que ele será usado para criar um novo movimento de estoque
    public StockMovementDTO save(@RequestBody StockMovement stockMovement) {
        return StockMovementDTO.fromEntity(service.save(stockMovement));
    }

    @DeleteMapping("/{id}") // mapeia as requisições DELETE para este método, indicando que ele será usado para excluir um movimento de estoque existente com base no ID fornecido na URL
    public StockMovementDTO delete(@PathVariable String id) {
        return StockMovementDTO.fromEntity(service.delete(id));
    }
}
