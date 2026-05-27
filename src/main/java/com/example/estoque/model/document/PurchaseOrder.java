package com.example.estoque.model.document;

import com.example.estoque.model.embedded.OrderItem;
import com.example.estoque.model.enums.StatusOrder;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "purchase_orders")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class PurchaseOrder {

    @Id
    private String id;
    private String supplierId;
    private String userId;
    private List<OrderItem> items;
    private LocalDateTime moment;
    private StatusOrder status;

    public Double total() {
        Double sum = 0.0;
        for (OrderItem item : items) {
            sum = sum + item.subtotal();
        }
        return sum;
    }
}
