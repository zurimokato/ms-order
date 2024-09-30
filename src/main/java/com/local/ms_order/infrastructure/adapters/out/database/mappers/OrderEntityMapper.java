package com.local.ms_order.infrastructure.adapters.out.database.mappers;

import com.local.ms_order.domain.model.Order;
import com.local.ms_order.infrastructure.adapters.out.database.entities.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderLineEntityMapper.class})
public interface OrderEntityMapper {
    OrderEntity toEntity(final Order order);
    Order toModel(final OrderEntity entity);
}
