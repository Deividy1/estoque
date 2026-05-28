package com.example.estoque.controller;


import com.example.estoque.dto.UserDTO;
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
    public UserDTO findById(@PathVariable String id) {
        return UserDTO.fromUser(service.findById(id));
    }

    // Busca todos os usuários e retorna uma lista
    @GetMapping
    public List<UserDTO> findAll() {
        return service.findAll().stream()
                .map(UserDTO::fromUser)
                .toList();
    }

    @PostMapping // mapeia as requisições POST para este método, indicando que ele será usado para criar um novo usuário
    public UserDTO save(@RequestBody User user) {
        return UserDTO.fromUser(service.save(user));
    }

    @DeleteMapping("/{id}") // mapeia as requisições DELETE para este método, indicando que ele será usado para excluir um usuário existente com base no ID fornecido na URL
    public UserDTO delete(@PathVariable String id) {
        return UserDTO.fromUser(service.delete(id));
    }
}
