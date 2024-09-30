package com.local.ms_order.infrastructure.adapters.out.database;

import com.local.ms_order.application.port.out.OrderOutputPort;
import com.local.ms_order.domain.model.Order;
import com.local.ms_order.infrastructure.adapters.out.database.mappers.OrderEntityMapper;
import com.local.ms_order.infrastructure.adapters.out.database.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderOutputPort {
    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;
    @Override
    public Order save(Order order) {
        return orderEntityMapper.toModel(
                orderRepository.save(
                        orderEntityMapper.toEntity(order)
                )
        );
    }

    @Override
    public Order findById(String id) {
        return orderEntityMapper.toModel(
                orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order not found"))
        );
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable)
                .map(orderEntityMapper::toModel);
    }

    @Override
    public Page<Order> findByCustomerId(Long customerId, Pageable pageable) {
        return orderRepository.findAllByCustomerId(customerId,pageable)
                .map(orderEntityMapper::toModel);
    }

    @Override
    public Page<Order> findByCustomerDocument(String customerId, Pageable pageable) {
        return orderRepository.findAllByCustomerDocument(customerId, pageable)
                .map(orderEntityMapper::toModel);
    }
}
