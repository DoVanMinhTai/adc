package com.adc.order.service;

import com.adc.commonlibrary.utils.AuthenticationUtils;
import com.adc.order.mapper.CheckoutMapper;
import com.adc.order.model.Checkout;
import com.adc.order.model.CheckoutItem;
import com.adc.order.model.enumeration.CheckoutState;
import com.adc.order.repository.CheckoutRepository;
import com.adc.order.viewmodel.checkout.CheckOutItemPostVm;
import com.adc.order.viewmodel.checkout.CheckoutPostVm;
import com.adc.order.viewmodel.checkout.CheckoutVm;
import com.adc.order.viewmodel.product.ProductCheckoutListVm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    private final CheckoutRepository checkoutRepository;
    private final CheckoutMapper checkoutMapper;
    private final ProductService productService;
    public CheckoutVm createCheckout(CheckoutPostVm checkoutPostVm) {
        Checkout checkout = checkoutMapper.toModel(checkoutPostVm);
//      authentication and create state checkout
        checkout.setCustomerId(AuthenticationUtils.extractUserId());
        checkout.setCheckoutState(CheckoutState.PENDING);

//      prepare list product in order
        prepareCheckoutItems(checkout,checkoutPostVm);

        return null;
    }

    private void prepareCheckoutItems(Checkout checkout, CheckoutPostVm checkoutPostVm) {
        Set<Long> productIds = checkoutPostVm.checkOutItemPostVms()
                .stream()
                .map(CheckOutItemPostVm::productId)
                .collect(Collectors.toSet());

        List<CheckoutItem> checkoutItemList = checkoutPostVm.checkOutItemPostVms()
                .stream()
                .map(checkoutMapper::toModel)
                .map(item -> {
                    item.setCheckout(checkout);
                    return item;
                })
                .toList();

        Map<Long, ProductCheckoutListVm> products =
                productService.getProductInformation(productIds,0, productIds.size());

    }
}
