package com.adc.order.service;

import com.adc.commonlibrary.exception.NotFoundException;
import com.adc.commonlibrary.utils.AuthenticationUtils;
import com.adc.commonlibrary.utils.MessagesUtils;
import com.adc.order.mapper.CheckoutMapper;
import com.adc.order.model.Checkout;
import com.adc.order.model.CheckoutItem;
import com.adc.order.model.OrderItem;
import com.adc.order.model.enumeration.CheckoutState;
import com.adc.order.repository.CheckoutRepository;
import com.adc.order.utils.Constants;
import com.adc.order.viewmodel.checkout.CheckOutItemPostVm;
import com.adc.order.viewmodel.checkout.CheckoutItemVm;
import com.adc.order.viewmodel.checkout.CheckoutPostVm;
import com.adc.order.viewmodel.checkout.CheckoutVm;
import com.adc.order.viewmodel.product.ProductCheckoutListVm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
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
        checkoutRepository.save(checkout);

        CheckoutVm checkoutVm = checkoutMapper.toVm(checkout);
        Set<CheckoutItemVm> checkoutItemVms = checkout.getCheckoutItems().stream().map(
                checkoutMapper::toVm)
                .collect(Collectors.toSet());
        log.info(Constants.MessageCode.CREATE_CHECKOUT,checkout.getId(),checkout.getCustomerId());
        return checkoutVm.toBuilder().checkoutItemVms(checkoutItemVms).build();
    }

    private void prepareCheckoutItems(Checkout checkout, CheckoutPostVm checkoutPostVm) {
        Set<Long> productIds = checkoutPostVm.checkOutItemPostVms()
                .stream()
                .map(CheckOutItemPostVm::productId)
                .collect(Collectors.toSet());

        List<CheckoutItem> checkoutItems = checkoutPostVm.checkOutItemPostVms()
                .stream()
                .map(checkoutMapper::toModel)
                .map(item -> {
                    item.setCheckout(checkout);
                    return item;
                })
                .toList();

        Map<Long, ProductCheckoutListVm> products =
                productService.getProductInformation(productIds,0, productIds.size());

//        gắn sản phẩm với checkout item
        List<CheckoutItem> enrichedItems = enrichCheckoutItemWithProductDetails(products,checkoutItems);

//        Tính tổng tiền của 1 đơn hang
        BigDecimal totalAmount =  enrichedItems.stream().map(
                item -> item.getProductPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        checkout.setCheckoutItems(enrichedItems);
        checkout.setTotalAmount(totalAmount);

    }

    private List<CheckoutItem> enrichCheckoutItemWithProductDetails(Map<Long, ProductCheckoutListVm> products,
                                                                 List<CheckoutItem> checkoutItems) {
        return checkoutItems.stream().map(item -> {
                ProductCheckoutListVm product = products.get(item.getId());
                if (product == null) {
                    throw new NotFoundException(MessagesUtils.getMessage("PRODUCT_NOT_FOUND", item.getId()));
                }
                return item.toBuilder()
                        .productName(product.getName())
                        .productPrice(BigDecimal.valueOf(product.getPrice()))
                        .build();
        }).toList();

    }
}
