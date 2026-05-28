package com.example.estoque.dto;

import com.example.estoque.model.document.PurchaseOrder;
import com.example.estoque.model.embedded.OrderItem;
import com.example.estoque.model.enums.StatusOrder;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class PurchaseOrderDTO {

    private String id;
    private String supplierId;
    private String userId;
    private List<OrderItem> items;
    private LocalDateTime moment;
    private StatusOrder status;

    public static PurchaseOrderDTO fromPurchaseOrder(PurchaseOrder purchaseOrder) {
        return PurchaseOrderDTO.builder()
                .id(purchaseOrder.getId())
                .supplierId(purchaseOrder.getSupplierId())
                .userId(purchaseOrder.getUserId())
                .items(purchaseOrder.getItems())
                .moment(purchaseOrder.getMoment())
                .status(purchaseOrder.getStatus())
                .build();
    }
}
