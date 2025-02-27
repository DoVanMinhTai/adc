package com.adc.order.controller;

import com.adc.order.service.OrderService;
import com.adc.order.viewmodel.order.OrderPostVm;
import com.adc.order.viewmodel.order.OrderVm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/completed/products")
    public ResponseEntity<List<Long>> getCompletedProducts() {
        return ResponseEntity.ok(orderService.findProductIdsByCompletedOrders());
    }
    
    @PostMapping("/storefront/orders")
    public ResponseEntity<OrderVm> createOrder(@RequestBody OrderPostVm orderPostVm) {
        return ResponseEntity.ok(orderService.createOrder(orderPostVm));
    }
}
