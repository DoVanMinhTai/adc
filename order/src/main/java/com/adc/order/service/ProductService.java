package com.adc.order.service;

import com.adc.order.config.ServiceUrlConfig;
import com.adc.order.viewmodel.product.ProductCheckoutListVm;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final RestClient restClient;
    private final ServiceUrlConfig serverUrlConfig;

    @Retry(name = "restApi")
    @CircuitBreaker(name = "restCircuitBreaker", fallbackMethod = "handleProductInformationFallBack")
    public Map<Long, ProductCheckoutListVm> getProductInformation(Set<Long> productIds, int i, int size) {
        return null;
    }
}
