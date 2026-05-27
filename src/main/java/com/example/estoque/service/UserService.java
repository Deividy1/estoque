package com.example.estoque.service;



import com.example.estoque.exception.NotFoundException;
import com.example.estoque.model.document.User;
import com.example.estoque.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    // Busca todos os usuarios no MongoDB e retorna uma lista.
    public List<User> findAll(){
        return repository.findAll();
    }

    // Busca o usuario pelo id, lança NotFoundException se não encontrado
    public User findById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario não encontrado"));
    }

    // Salva um usuario no banco de dados e retorna o usuario salvo
    public User save(User user) {
        return repository.save(user);
    }


    // Deleta o usuario pelo id, lança NotFoundException se não encontrado e retorna o usuario deletado
    public User delete(String id) {
        User user = findById(id);
        repository.delete(user);
        return user;
    }


}
