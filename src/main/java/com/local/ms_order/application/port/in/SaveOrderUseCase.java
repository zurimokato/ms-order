package com.local.ms_order.application.port.in;

import com.local.ms_order.domain.model.Order;

public interface SaveOrderUseCase {
    Order save(Order order);
    Order update(Order order);
}
