package com.local.ms_order.infrastructure.adapters.in.rest.controller.response;

import com.local.ms_order.domain.enums.OrderStatus;
import com.local.ms_order.domain.enums.OrderType;
import com.local.ms_order.domain.enums.PayMethod;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String id;
    private LocalDateTime orderDate;
    private Long customerId;
    private String customerDocument;
    private OrderStatus status;
    private PayMethod payMethod;
    private OrderType orderType;
    private List<OrderLineResponse> orderLines;
    private double totalPrice;
}
