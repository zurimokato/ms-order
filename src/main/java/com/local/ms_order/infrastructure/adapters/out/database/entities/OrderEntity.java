package com.local.ms_order.infrastructure.adapters.out.database.entities;

import com.local.ms_order.domain.enums.OrderStatus;
import com.local.ms_order.domain.enums.OrderType;
import com.local.ms_order.domain.enums.PayMethod;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("orders")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String id;
    private LocalDateTime orderDate;
    private Long customerId;
    private String customerDocument;
    private OrderStatus status;
    private PayMethod payMethod;
    private OrderType orderType;
    private List<OrderLineEntity> orderLines;
    private double totalPrice;

}
