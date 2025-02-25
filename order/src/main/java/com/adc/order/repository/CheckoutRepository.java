package com.adc.order.repository;

import com.adc.order.model.Checkout;
import com.adc.order.model.CheckoutItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout,String> {
}
