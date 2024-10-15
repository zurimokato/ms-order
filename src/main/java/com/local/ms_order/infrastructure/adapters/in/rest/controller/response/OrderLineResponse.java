package com.local.ms_order.infrastructure.adapters.in.rest.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineResponse {

    private String orderId;
    private String productId;
    private String name;
    private int quantity;
    private double price;
    private double subtotal;
}
