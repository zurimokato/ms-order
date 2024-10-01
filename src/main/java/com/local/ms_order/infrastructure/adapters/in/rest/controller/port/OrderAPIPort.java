package com.local.ms_order.infrastructure.adapters.in.rest.controller.port;

import com.local.ms_order.infrastructure.adapters.in.rest.controller.request.OrderRequest;
import com.local.ms_order.infrastructure.adapters.in.rest.controller.response.GenericResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface OrderAPIPort {
    @GetMapping
    ResponseEntity<GenericResponse> getOrders(Pageable pageable);
    @GetMapping("/by-customer-id/{customerId}")
    ResponseEntity<GenericResponse> getOrderByCustomerId(@PathVariable("customerId") Long customerId, Pageable pageable);
    @GetMapping("by-costumer-document/{customerDocument}")
    ResponseEntity<GenericResponse> getOrdersByCustomerDocument(@PathVariable("customerDocument") String customerDocument, Pageable pageable);
    @GetMapping("/{orderId}")
    ResponseEntity<GenericResponse> getOrderByOrderId(@PathVariable("orderId") String orderId);
    @PostMapping
    ResponseEntity<GenericResponse> createOrder(@RequestBody OrderRequest orderRequest) throws Exception;
    @PutMapping
    ResponseEntity<GenericResponse> updateOrder(@RequestBody OrderRequest orderRequest);


}
