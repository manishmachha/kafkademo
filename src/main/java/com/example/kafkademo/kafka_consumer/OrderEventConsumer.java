package com.example.kafkademo.kafka_consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkademo.entity.Order;
import com.example.kafkademo.service.EmailService;

@Service
public class OrderEventConsumer {
    
    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "order-events", groupId = "email-group", containerFactory = "orderKafkaListenerContainerFactory")
    public void consume(Order order) {
        String subject = "🛍️ Order Confirmation - Order ID: " + order.getId();
        String body = "Hi, your order for " + order.getProductName() + " (Qty: " + order.getQuantity() +
                ") has been placed successfully.";
        emailService.sendEmail(order.getEmail(), subject, body);
    }
}
