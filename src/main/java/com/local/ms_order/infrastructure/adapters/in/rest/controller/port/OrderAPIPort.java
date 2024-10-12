package com.local.ms_order.infrastructure.adapters.in.rest.controller.port;

import com.local.ms_order.infrastructure.adapters.in.rest.controller.request.OrderRequest;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.response.GenericResponse;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

public interface OrderAPIPort {
    @GetMapping
    GenericResponse getOrders(Pageable pageable);
    @GetMapping("/by-customer-id/{customerId}")
    GenericResponse getOrderByCustomerId(@PathVariable("customerId") Long customerId, Pageable pageable);
    @GetMapping("by-costumer-document/{customerDocument}")
    GenericResponse getOrdersByCustomerDocument(@PathVariable("customerDocument") String customerDocument, Pageable pageable);
    @GetMapping("/{orderId}")
    GenericResponse getOrderByOrderId(@PathVariable("orderId") String orderId);
    @PostMapping
    GenericResponse createOrder(@RequestBody OrderRequest orderRequest) throws Exception;
    @PutMapping
    GenericResponse updateOrder(@RequestBody OrderRequest orderRequest);


}
