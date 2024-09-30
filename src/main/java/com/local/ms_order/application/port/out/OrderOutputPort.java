package com.local.ms_order.application.port.out;

import com.local.ms_order.domain.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderOutputPort {
    Order save(Order order);
    Order findById(String id);
    Page<Order> findAll(Pageable pageable);
    Page<Order> findByCustomerId(Long customerId, Pageable pageable);
    Page<Order> findByCustomerDocument(String customerId, Pageable pageable);
}
