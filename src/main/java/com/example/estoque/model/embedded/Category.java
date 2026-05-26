package com.example.estoque.model.embedded;


import lombok.*;

@ToString //cria o método toString automaticamente
@AllArgsConstructor //cria um construtor com todos os argumentos automaticamente
@NoArgsConstructor //cria um construtor sem argumentos automaticamente
@Setter //cria os métodos set automaticamente
@Getter //cria os métodos get automaticamente
public class Category {


    private String id;
    private String name;
    private String description;




}
