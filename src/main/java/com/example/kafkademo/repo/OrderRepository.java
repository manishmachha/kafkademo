package com.example.kafkademo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kafkademo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
