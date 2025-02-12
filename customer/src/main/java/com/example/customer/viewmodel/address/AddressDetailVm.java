package com.example.customer.viewmodel.address;

public record AddressDetailVm(
        Long id, String contactName, String street, String city, String state, String zip, String country
) {
}
