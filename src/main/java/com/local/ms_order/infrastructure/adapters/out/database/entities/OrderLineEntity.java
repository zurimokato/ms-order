package com.local.ms_order.infrastructure.adapters.out.database.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineEntity {
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
    private double subtotal;
}
