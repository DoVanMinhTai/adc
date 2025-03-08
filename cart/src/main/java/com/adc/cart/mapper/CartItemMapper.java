package com.adc.cart.mapper;

import com.adc.cart.model.CartItem;
import com.adc.cart.viewmodel.CartItemGetVm;
import com.adc.cart.viewmodel.CartItemPost;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {
    public  CartItem toCartItem(CartItemPost cartItemPostVm,String currentUser) {
        return  CartItem.builder()
                .customerId(currentUser)
                .productId(cartItemPostVm.productId())
                .quantity(cartItemPostVm.quantity()).build();
    }

    public CartItemGetVm toGetVm(CartItem cartItem) {
        return CartItemGetVm
                .builder()
                .customerId(cartItem.getCustomerId())
                .productId(cartItem.getProductId())
                .quantity(cartItem.getQuantity())
                .build();
    }
}
