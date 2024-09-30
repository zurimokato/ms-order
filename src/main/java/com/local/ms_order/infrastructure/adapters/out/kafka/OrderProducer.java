package com.local.ms_order.infrastructure.adapters.out.kafka;

import com.local.ms_order.application.port.out.OrderProducerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer implements OrderProducerOutputPort {

    @Value("${spring.kafka.topic.order-topic}")
    private String orderTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void sendOrderEvent(String orderEvent) {
        kafkaTemplate.send(orderTopic, orderEvent);
    }
}
