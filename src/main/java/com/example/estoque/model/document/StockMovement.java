package com.example.estoque.model.document;

import com.example.estoque.model.enums.MovementType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "stock_movements")
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StockMovement {


    @Id
    private String id;
    private String stockId;
    private String userId;
    private Integer quantity;
    private LocalDateTime moment;
    private String reason;
    private MovementType type;
}
