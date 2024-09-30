package com.local.ms_order.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderLine {
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    private double subtotal;
}
