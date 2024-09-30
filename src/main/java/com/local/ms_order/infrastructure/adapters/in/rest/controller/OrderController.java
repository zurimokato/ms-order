package com.local.ms_order.infrastructure.adapters.in.rest.controller;

import com.local.ms_order.application.port.in.FindOrderUseCase;
import com.local.ms_order.application.port.in.SaveOrderUseCase;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.mapper.OrderRestMapper;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.port.OrderAPIPort;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.request.OrderRequest;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.response.GenericResponse;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/orders")
@RequiredArgsConstructor
public class OrderController implements OrderAPIPort {
    private final FindOrderUseCase findOrderUseCase;
    private final SaveOrderUseCase saveOrderUseCase;
    private final OrderRestMapper orderRestMapper;

    @Override
    public ResponseEntity<GenericResponse> getOrders(Pageable pageable) {

        Page<OrderResponse> page = findOrderUseCase.findAllOrders(pageable)
                .map(orderRestMapper::toResponse);

        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(orderRestMapper.toPageResponse(page));
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> getOrderByCustomerId(Long customerId, Pageable pageable) {

        Page<OrderResponse> page = findOrderUseCase.findAllOrdersByCustomerId(customerId, pageable)
                .map(orderRestMapper::toResponse);

        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(orderRestMapper.toPageResponse(page));
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> getOrdersByCustomerDocument(String customerDocument, Pageable pageable) {
        Page<OrderResponse> page = findOrderUseCase.findAllOrdersByCustomerDocument(customerDocument, pageable)
                .map(orderRestMapper::toResponse);

        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(orderRestMapper.toPageResponse(page));
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> getOrderByOrderId(String orderId) {
        OrderResponse orderResponse = orderRestMapper.toResponse(findOrderUseCase.findOrder(orderId));
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(orderResponse);
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> createOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse=orderRestMapper.toResponse(
                saveOrderUseCase.save(orderRestMapper.toDomain(orderRequest))
        );
        log.info("response save {}",orderResponse);
        GenericResponse genericResponse = GenericResponse.success();
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> updateOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse=orderRestMapper.toResponse(
                saveOrderUseCase.update(orderRestMapper.toDomain(orderRequest))
        );
        log.info("response updated {}",orderResponse);
        GenericResponse genericResponse = GenericResponse.success();
        return ResponseEntity.ok(genericResponse);
    }
}
