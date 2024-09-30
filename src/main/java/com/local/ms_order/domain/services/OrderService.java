package com.local.ms_order.domain.services;

import com.local.ms_order.application.port.in.FindOrderUseCase;
import com.local.ms_order.application.port.in.SaveOrderUseCase;
import com.local.ms_order.application.port.out.OrderOutputPort;
import com.local.ms_order.domain.enums.OrderType;
import com.local.ms_order.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService implements SaveOrderUseCase, FindOrderUseCase {
    private final OrderOutputPort orderOutputPort;

    @Override
    public Order findOrder(String id) {
        return orderOutputPort.findById(id);
    }

    @Override
    public Page<Order> findAllOrders(Pageable pageable) {
        Page<Order> orders = orderOutputPort.findAll(pageable);
        if (orders.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        return orders;
    }

    @Override
    public Page<Order> findAllOrdersByCustomerId(Long customerId, Pageable pageable) {
        Page<Order> orders = orderOutputPort.findByCustomerId(customerId, pageable);
        if (orders.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        return orders;
    }

    @Override
    public Page<Order> findAllOrdersByCustomerDocument(String customerDocument, Pageable pageable) {
        Page<Order> orders = orderOutputPort.findByCustomerDocument(customerDocument, pageable);
        if (orders.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        return orders;
    }

    @Override
    public Order save(Order order) {
        if(order.getOrderType()== OrderType.VENTA && order.getOrderLines().isEmpty()){
            throw new RuntimeException("Venta order line is empty");
        }
        if(order.getOrderType()==OrderType.ENCARGO){
            //send to kafka
        }
        return orderOutputPort.save(order);
    }

    @Override
    public Order update(Order order) {
        Order updatedOrder = findOrder(order.getId());
        return orderOutputPort.save(updatedOrder);
    }
}
