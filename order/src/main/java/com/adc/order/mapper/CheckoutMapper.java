package com.adc.order.mapper;

import com.adc.order.model.Checkout;
import com.adc.order.model.CheckoutItem;
import com.adc.order.viewmodel.checkout.CheckOutItemPostVm;
import com.adc.order.viewmodel.checkout.CheckoutPostVm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CheckoutMapper {
    
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "checkout",ignore = true)
    CheckoutItem toModel (CheckOutItemPostVm checkoutItemPostVm);
    
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "state",ignore = true)
    Checkout toModel(CheckoutPostVm checkoutPostVm);
    
    
}
