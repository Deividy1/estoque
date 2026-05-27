package com.example.estoque.exception;

//Exceção lançada quando um recurso não é encontrado no banco de dados
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message); // passa a mensagem para a classe pai RuntimeException
    }
}
