package com.sparta.crudshadowing.repository;

import com.sparta.crudshadowing.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
