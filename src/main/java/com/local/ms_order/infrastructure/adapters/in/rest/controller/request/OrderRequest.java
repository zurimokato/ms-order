package com.local.ms_order.infrastructure.adapters.in.rest.controller.request;

import com.local.ms_order.domain.enums.OrderStatus;
import com.local.ms_order.domain.enums.OrderType;
import com.local.ms_order.domain.enums.PayMethod;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class OrderRequest {
    private String id;
    @NotNull
    private LocalDateTime orderDate;
    @NotNull
    private Long customerId;
    @NotNull
    @NotEmpty
    private String customerDocument;
    private OrderStatus status;
    @NotNull
    private PayMethod payMethod;
    @NotNull
    private OrderType orderType;
    private List<OrderLineRequest> orderLines;
    private double totalPrice;
}
