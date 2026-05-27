package com.example.estoque.model.embedded;

import lombok.*;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderItem {


    private String productId;
    private Integer quantity;
    private Double unitPrice;

    public Double subtotal() {
        return quantity * unitPrice;

    }

}
