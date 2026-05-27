package com.example.estoque.model.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@ToString
@Document(collection = "suppliers") //indica que esta classe é um documento do MongoDB e especifica o nome da coleção onde os documentos serão armazenados
@Builder //cria um construtor com o padrão de projeto Builder automaticamente
@AllArgsConstructor //cria um construtor com todos os argumentos automaticamente
@NoArgsConstructor //cria um construtor sem argumentos automaticamente
@Setter //cria os métodos set automaticamente
@Getter //cria os métodos get automaticamente
public class Supplier {

    @Id //indica que o campo id é a chave primária do documento
    private String id;
    private String name;
    private String email;
    private  String phone;
    private  String cnpj;
}
