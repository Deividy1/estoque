package com.example.estoque.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item_stock") //indica que esta classe é um documento do MongoDB e especifica o nome da coleção onde os documentos serão armazenados
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ItemStock {

    @Id
    private String id;
    private String productId;
    private Integer quantity;
    private String localization;

    public Boolean isLow(Integer minimum) {
        if (quantity < minimum) {
            return true;
        } else {
            return false;
        }
    }
}