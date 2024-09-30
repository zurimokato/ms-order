package com.local.ms_order.infrastructure.adapters.in.rest.controller.mapper;

import com.local.ms_order.domain.model.Order;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.request.OrderRequest;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.response.OrderResponse;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.response.PageResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = {OrderLineRestMapper.class})
public interface OrderRestMapper {
    OrderResponse toResponse(Order order);
    Order toDomain(OrderRequest source);
    PageResponse toPageResponse(Page<OrderResponse> source);
}
