package com.example.kafkademo.kafka_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafkademo.entity.Order;

@Service
public class OrderEventProducer {
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void publishOrderEvent(Order order) {
        kafkaTemplate.send("order-events", order);
    }
}
