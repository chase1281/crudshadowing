package com.sparta.crudshadowing.dto;

import com.sparta.crudshadowing.entity.Order;
import lombok.Getter;

@Getter
public class OrderResponse {
    private final Long id;
    private final String name;
    private final Integer price;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.name = order.getProduct().getName();
        this.price = order.getProduct().getPrice();
    }
}
