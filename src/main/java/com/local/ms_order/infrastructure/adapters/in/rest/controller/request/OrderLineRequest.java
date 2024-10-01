package com.local.ms_order.infrastructure.adapters.in.rest.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderLineRequest {
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
    private double subtotal;
}
