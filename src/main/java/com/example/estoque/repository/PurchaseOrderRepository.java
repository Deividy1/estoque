package com.example.estoque.repository;

import com.example.estoque.model.document.PurchaseOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseOrderRepository extends MongoRepository <PurchaseOrder, String> {
}
