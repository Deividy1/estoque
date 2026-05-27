package com.example.estoque.repository;


import com.example.estoque.model.document.StockMovement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockMovementRepository extends MongoRepository<StockMovement, String> {
}
