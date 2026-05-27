package com.example.estoque.controller;

import com.example.estoque.model.document.User;
import com.example.estoque.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users") // mapeia as requisições para /users
@RestController // Indica que esta classe é um controlador REST e que os métodos retornarão dados diretamente no corpo da resposta
@AllArgsConstructor
public class UserController {

    private final UserService service;

    // Busca um usuário pelo id, lança NotFoundException se não encontrado
    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return service.findById(id);
    }

    // Busca todos os usuários e retorna uma lista
    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @PostMapping // mapeia as requisições POST para este método, indicando que ele será usado para criar um novo usuário
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @DeleteMapping("/{id}") // mapeia as requisições DELETE para este método, indicando que ele será usado para excluir um usuário existente com base no ID fornecido na URL
    public User delete(@PathVariable String id) {
        return service.delete(id);
    }
}
