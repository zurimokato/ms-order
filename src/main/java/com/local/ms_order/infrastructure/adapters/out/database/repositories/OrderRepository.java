package com.local.ms_order.infrastructure.adapters.out.database.repositories;

import com.local.ms_order.domain.model.Order;
import com.local.ms_order.infrastructure.adapters.out.database.entities.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity,String> {

    Page<OrderEntity> findAllByCustomerId(Long id, Pageable pageable);

    Page<OrderEntity> findAllByCustomerDocument(String customerDocument, Pageable pageable);
}
