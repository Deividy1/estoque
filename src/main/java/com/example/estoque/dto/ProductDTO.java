package com.example.estoque.dto;

import com.example.estoque.model.document.Product;
import com.example.estoque.model.embedded.Category;
import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDTO {

        private String id;
        private String name;
        private String description;
        private Double costPrice;
        private Double salePrice;
        private Integer stockMinimum;
        private String unit;
        private String imgUrl;
        private Category category;

        // converte um Product em ProductDTO
        public static ProductDTO fromProduct(Product product) {
            return ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .costPrice(product.getCostPrice())
                    .salePrice(product.getSalePrice())
                    .stockMinimum(product.getStockMinimum())
                    .unit(product.getUnit())
                    .imgUrl(product.getImgUrl())
                    .category(product.getCategory())
                    .build();
        }

}
