package com.adc.cart.controller;

import com.adc.cart.service.CartItemService;
import com.adc.cart.viewmodel.CartItemGetVm;
import com.adc.cart.viewmodel.CartItemPost;
import com.adc.cart.viewmodel.CartItemPutVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;

    @PostMapping("/storefront/cart/add")
    public ResponseEntity<CartItemGetVm> addCartItem(@RequestBody CartItemPost cartItemPost) {
        return ResponseEntity.ok(cartItemService.addCartItem(cartItemPost));
    }

    @PutMapping("/storefront/cart/update/{productId}")
    public ResponseEntity<CartItemGetVm> updateCartItem(@PathVariable @Valid Long productId, @RequestBody CartItemPutVm cartItemPutVm) {
        return ResponseEntity.ok(cartItemService.updateCartItem(productId,cartItemPutVm));
    }

    @GetMapping("/storefront/cart/list")
    public ResponseEntity<List<CartItemGetVm>> getCartItems() {
        return ResponseEntity.ok(cartItemService.getCartItems());
    }

}
