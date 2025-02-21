package com.adc.order.service;

import com.adc.commonlibrary.exception.NotFoundException;
import com.adc.commonlibrary.utils.AuthenticationUtils;
import com.adc.order.config.ServiceUrlConfig;
import com.adc.order.viewmodel.product.ProductCheckoutListVm;
import com.adc.order.viewmodel.product.ProductGetCheckOutListVm;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService extends AbstractCircuitBreakFallbackHandler {
    private final RestClient restClient;
    private final ServiceUrlConfig serverUrlConfig;

    @Retry(name = "restApi")
    @CircuitBreaker(name = "restCircuitBreaker", fallbackMethod = "handleProductInformationFallBack")
    public Map<Long, ProductCheckoutListVm> getProductInformation(Set<Long> ids, int pageNo, int pageSize) {
        final String jwt = AuthenticationUtils.extractJwt();
        final URI url = UriComponentsBuilder.fromHttpUrl(serverUrlConfig.product())
                .path("/products")
                .queryParam("ids",ids)
                .queryParam("pageNo",pageNo)
                .queryParam("pageSize",pageSize)
                .buildAndExpand()
                .toUri();

        ProductGetCheckOutListVm reponse = restClient.get()
                .uri(url)
                .headers(h -> h.setBearerAuth(jwt))
                .retrieve()
                .toEntity(new ParameterizedTypeReference<ProductGetCheckOutListVm>() {
                })
                .getBody();
        if (reponse == null || reponse.productCheckoutListVms() == null) {
            throw  new NotFoundException("PRODUCT_NOT_FOUND");
        } else {
            return reponse.productCheckoutListVms()
                    .stream()
                    .collect(Collectors.toMap(ProductCheckoutListVm::getId, Function.identity()));
        }

    }
    protected Map<Long, ProductCheckoutListVm> handleProductInfomationFallback(Throwable throwable) throws Throwable {
        return handleTypedFallback(throwable);
    }
}
