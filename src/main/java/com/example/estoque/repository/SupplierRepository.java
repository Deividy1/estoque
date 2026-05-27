package com.example.estoque.repository;

import com.example.estoque.model.document.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository extends MongoRepository<Supplier, String> {
}
