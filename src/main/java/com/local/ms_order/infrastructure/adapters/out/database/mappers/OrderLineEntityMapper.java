package com.local.ms_order.infrastructure.adapters.out.database.mappers;

import com.local.ms_order.domain.model.OrderLine;
import com.local.ms_order.infrastructure.adapters.out.database.entities.OrderLineEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineEntityMapper {
    OrderLineEntity toEntity(final OrderLine source);
    OrderLine toModel(final OrderLineEntity source);
}
