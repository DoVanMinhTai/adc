package com.adc.location.viewmodel.address;

import lombok.Builder;

@Builder
public record AddressDetailVm(Long id,String contactName, String phone, String addressLine1,
                              String addressLine2, String city,
                              String zipCode,Long districtId, Long stateOrProvinceId, Long countryId) {
    public static AddressDetailVm fromModel(com.adc.location.model.Address address) {
        return AddressDetailVm.builder()
                .id(address.getId())
                .contactName(address.getContactName())
                .phone(address.getPhone())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .zipCode(address.getZipCode())
                .districtId(address.getDistrict().getId())
                .stateOrProvinceId(address.getStateOrProvince().getId())
                .countryId(address.getCountry().getId())
                .build();
    }
}
