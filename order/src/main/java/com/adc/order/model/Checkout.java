package com.adc.order.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

//model lưu lại 1 phiên thanh toán
@Builder
public class Checkout {
    @SuppressWarnings("unused")
    private String customerId;

    @OneToMany(mappedBy = "checkout", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @Builder.Default
    private List<CheckoutItem> checkoutItems = new ArrayList<>();
}
