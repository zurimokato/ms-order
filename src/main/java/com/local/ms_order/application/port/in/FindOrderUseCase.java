package com.local.ms_order.application.port.in;

import com.local.ms_order.domain.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindOrderUseCase {
    Order findOrder(String id);
    Page<Order> findAllOrders(Pageable pageable);
    Page<Order> findAllOrdersByCustomerId(Long customerId,Pageable pageable);
    Page<Order> findAllOrdersByCustomerDocument(String customerDocument,Pageable pageable);
}
