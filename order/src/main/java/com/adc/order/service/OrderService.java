package com.adc.order.service;

import com.adc.order.repository.OrderItemRepository;
import com.adc.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public List<Long> findProductIdsByCompletedOrders() {
        return orderItemRepository.findProductIdsByCompletedOrders();
    }
}
