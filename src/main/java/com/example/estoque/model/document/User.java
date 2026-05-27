package com.example.estoque.model.document;

import com.example.estoque.model.enums.UserProfile;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users") //indica que esta classe é um documento do MongoDB e especifica o nome da coleção onde os documentos serão armazenados
@Builder //cria um construtor com o padrão de projeto Builder automaticamente
@ToString //cria o método toString automaticamente
@AllArgsConstructor //cria um construtor com todos os argumentos automaticamente
@NoArgsConstructor //cria um construtor sem argumentos automaticamente
@Setter
@Getter
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String passwordHash;
    private UserProfile profile;


}
