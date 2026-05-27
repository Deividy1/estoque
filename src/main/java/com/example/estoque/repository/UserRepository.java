package com.example.estoque.repository;


import com.example.estoque.model.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
