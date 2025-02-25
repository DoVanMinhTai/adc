package com.adc.order.controller;

import com.adc.order.model.Checkout;
import com.adc.order.service.CheckoutService;
import com.adc.order.viewmodel.checkout.CheckoutPaymentMethodPutVm;
import com.adc.order.viewmodel.checkout.CheckoutPostVm;
import com.adc.order.viewmodel.checkout.CheckoutVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping("/storefront/checkouts")
    public ResponseEntity<CheckoutVm> checkout(@Valid @RequestBody CheckoutPostVm checkoutPostVm) {
        return ResponseEntity.ok(checkoutService.createCheckout(checkoutPostVm));
    }

    @PutMapping("/storefront/checkouts/{id}/payment-method")
    public ResponseEntity<Void> updatePaymentMethod(@PathVariable final String id,
                                                    @Valid @RequestBody
                                                    final CheckoutPaymentMethodPutVm checkoutPaymentMethodPutVm) {
        checkoutService.updateCheckoutPaymentMethod(id,checkoutPaymentMethodPutVm);
        return ResponseEntity.ok().build();
    }
}
