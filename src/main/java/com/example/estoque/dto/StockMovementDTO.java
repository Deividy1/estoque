package com.example.estoque.dto;

import com.example.estoque.model.document.StockMovement;
import com.example.estoque.model.enums.MovementType;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StockMovementDTO {

    private String id;
    private String stockId;
    private String userId;
    private Integer quantity;
    private LocalDateTime moment;
    private String reason;
    private MovementType type;

    public static StockMovementDTO fromEntity(StockMovement stockMovement) {
        return StockMovementDTO.builder()
                .id(stockMovement.getId())
                .stockId(stockMovement.getStockId())
                .userId(stockMovement.getUserId())
                .quantity(stockMovement.getQuantity())
                .moment(stockMovement.getMoment())
                .reason(stockMovement.getReason())
                .type(stockMovement.getType())
                .build();
    }
}
