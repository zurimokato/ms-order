package com.local.ms_order.infrastructure.adapters.out.database.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineEntity {
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    private double subtotal;
}
