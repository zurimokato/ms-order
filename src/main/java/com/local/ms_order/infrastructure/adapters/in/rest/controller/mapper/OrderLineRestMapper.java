package com.local.ms_order.infrastructure.adapters.in.rest.controller.mapper;

import com.local.ms_order.domain.model.OrderLine;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.request.OrderLineRequest;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.response.OrderLineResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineRestMapper {

    OrderLineResponse toResponse(OrderLine orderLine);

    OrderLine toModel(OrderLineRequest source);
}
