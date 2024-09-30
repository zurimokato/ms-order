package com.local.ms_order.application.port.out;


public interface OrderProducerOutputPort {

    void sendOrderEvent(String orderEvent) ;
}
