package com.example.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkademo.entity.Order;
import com.example.kafkademo.kafka_producer.OrderEventProducer;
import com.example.kafkademo.repo.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private  OrderRepository orderRepo;
    @Autowired
    private  OrderEventProducer producer;


    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order saved = orderRepo.save(order);
        producer.publishOrderEvent(saved);
        return ResponseEntity.ok(saved);
    }
}
