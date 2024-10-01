package com.local.ms_order.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderLine {
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
    private double subtotal;
}
