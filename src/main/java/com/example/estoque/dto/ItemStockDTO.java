package com.example.estoque.dto;

import com.example.estoque.model.document.ItemStock;
import lombok.*;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ItemStockDTO {

    private String id;
    private String productId;
    private Integer quantity;
    private String localization;

    public static ItemStockDTO fromEntity(ItemStock itemStock) {
        return ItemStockDTO.builder()
                .id(itemStock.getId())
                .productId(itemStock.getProductId())
                .quantity(itemStock.getQuantity())
                .localization(itemStock.getLocalization())
                .build();
    }
}
