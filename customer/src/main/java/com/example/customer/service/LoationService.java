package com.example.customer.service;

import com.example.customer.config.ServiceUrlConfig;
import com.example.customer.viewmodel.address.AddressDetailVm;
import com.example.customer.viewmodel.address.AddressVm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class LoationService {
    private final RestClient restClient;
    private final ServiceUrlConfig serviceUrlConfig;

    public AddressDetailVm getAddressById(Long id) {
        final String jwt = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getTokenValue();

        final URI uri = UriComponentsBuilder.fromHttpUrl(serviceUrlConfig.location())
                .path("/storefront/address/{id}")
                .buildAndExpand(id)
                .toUri();
        return restClient.get()
                .uri(uri)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(jwt))
        .retrieve().body(AddressDetailVm.class);
    }

    public AddressVm createAddress(AddressVm addressVm) {
        final String jwt = ((Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getTokenValue();

        final URI uri = UriComponentsBuilder.fromHttpUrl(serviceUrlConfig.location())
                .path("/storefront/addresses")
                .buildAndExpand().toUri();
        return restClient.get().uri(uri).headers(httpHeaders -> httpHeaders.setBearerAuth(jwt))
                .retrieve().body(AddressVm.class);
    }
}
