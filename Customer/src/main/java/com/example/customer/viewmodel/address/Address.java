package com.example.customer.viewmodel.address;

import lombok.Builder;

@Builder
public record Address(Long id, String street, String city, String state, String zip, String country) {
}
