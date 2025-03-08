package com.adc.cart.controller;

import com.adc.cart.service.CartItemService;
import com.adc.cart.viewmodel.CartItemGetVm;
import com.adc.cart.viewmodel.CartItemPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;

    @PutMapping("/storefront/cart")
    public ResponseEntity<CartItemGetVm> addCartItem(@RequestBody CartItemPost cartItemPost) {
        return ResponseEntity.ok(cartItemService.addCartItem(cartItemPost));
    }
}
