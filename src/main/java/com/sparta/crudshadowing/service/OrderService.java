package com.sparta.crudshadowing.service;

import com.sparta.crudshadowing.dto.OrderRequest;
import com.sparta.crudshadowing.dto.OrderResponse;
import com.sparta.crudshadowing.entity.Order;
import com.sparta.crudshadowing.entity.Product;
import com.sparta.crudshadowing.repository.OrderRepository;
import com.sparta.crudshadowing.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponse createOrder(OrderRequest request){
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다. id=" + request.getProductId()));
        Order order = new Order(product);
        Order saved = orderRepository.save(order);
        return new OrderResponse(saved);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다. id=" + id));
        return new OrderResponse(order);
    }

}
