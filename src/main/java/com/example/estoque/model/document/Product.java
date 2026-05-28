package com.example.estoque.model.document;

import com.example.estoque.model.embedded.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document(collection = "products") //indica que esta classe é um documento do MongoDB e especifica o nome da coleção onde os documentos serão armazenados
@Builder //cria um construtor com o padrão de projeto Builder automaticamente
@AllArgsConstructor //cria um construtor com todos os argumentos automaticamente
@NoArgsConstructor //cria um construtor sem argumentos automaticamente
@Setter //cria os métodos set automaticamente
@Getter //cria os métodos get automaticamente
public class Product {

    @Id //indica que o campo id é a chave primária do documento
    private String id;

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotNull(message = "Preço de custo é obrigatório")
    @Positive(message = "Preço de custo deve ser positivo")
    private Double costPrice;

    @NotNull(message = "Preço de venda é obrigatório")
    @Positive(message = "Preço de venda deve ser positivo")
    private Double salePrice;

    @NotNull(message = "Estoque mínimo é obrigatório")
    @Min(value = 0, message = "Estoque mínimo não pode ser negativo")
    private Integer stockMinimum;
    private String unit;
    private String imgUrl;
    private Category category;


}
