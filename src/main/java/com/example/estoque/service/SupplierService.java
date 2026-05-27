package com.example.estoque.service;


import com.example.estoque.exception.NotFoundException;
import com.example.estoque.model.document.Supplier;
import com.example.estoque.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplierService {

    private final SupplierRepository repository;

    // Busca todos os fornecedores no MongoDB e retorna uma lista.
    public List<Supplier> findAll(){
        return repository.findAll();
    }

    // Busca um fornecedor pelo id, lança NotFoundException se não encontrado
    public Supplier findById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));
    }

    // Salva um fornecedor no banco de dados e retorna o fornecedor salvo
    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }


    public Supplier delete(String id) {
        Supplier supplier = findById(id); // busca o produto para garantir que existe
        repository.delete(supplier); // deleta o produto do banco de dados
        return supplier; // retorna o produto deletado
    }



}
