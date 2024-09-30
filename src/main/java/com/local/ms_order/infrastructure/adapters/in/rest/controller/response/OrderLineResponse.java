package com.local.ms_order.infrastructure.adapters.in.rest.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderLineResponse {

    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    private double subtotal;
}
