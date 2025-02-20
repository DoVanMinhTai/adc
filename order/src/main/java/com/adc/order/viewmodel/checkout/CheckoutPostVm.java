package com.adc.order.viewmodel.checkout;

import java.util.List;

public record CheckoutPostVm(
        String email,
        String note,
        String promotionCode,
        String shipmentMethodId,
        String paymentMethodId,
        String shippingAddressId,
        List<CheckOutItemPostVm> checkOutItemPostVms
) {
}
