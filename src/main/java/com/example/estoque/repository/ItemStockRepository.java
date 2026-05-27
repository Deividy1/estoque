package com.example.estoque.repository;

import com.example.estoque.model.document.ItemStock;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ItemStockRepository extends MongoRepository<ItemStock, String> {
}
