package com.adc.location.service;

import com.adc.location.model.Address;
import com.adc.location.model.Country;
import com.adc.location.repository.AddressRepository;
import com.adc.location.repository.CountryRepository;
import com.adc.location.repository.DistrictRepository;
import com.adc.location.repository.StateOrProvinceRepository;
import com.adc.location.viewmodel.address.AddressDetailVm;
import com.adc.location.viewmodel.address.AddressPostVm;
import com.adc.location.viewmodel.address.AddressGetVm;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@lombok.RequiredArgsConstructor
@Transactional
public class AddressService {
    private final AddressRepository addressRepository;
    private final CountryRepository countryRepository;
    private final DistrictRepository districtRepository;
    private final StateOrProvinceRepository stateOrProvinceRepository;

    public AddressGetVm createAddress(@Valid AddressPostVm dto) {
        Address address = AddressPostVm.fromModel(dto);
        stateOrProvinceRepository.findById(dto.stateOrProvinceId()).ifPresent(address::setStateOrProvince);
        districtRepository.findById(dto.districtId()).ifPresent(address::setDistrict);
        Country country = countryRepository.findById(dto.countryId()).orElseThrow(
                () -> new IllegalArgumentException("Country not found")
        );
        address.setCountry(country);
        return AddressGetVm.fromModel(addressRepository.save(address));
    }

    public void updateAddress(Long id, @Valid AddressPostVm dto) {
    }

    public AddressDetailVm getAddressById(Long id) {
        return null;
    }

    public List<AddressDetailVm> getAddressList(List<Long> ids) {
        return null;
    }

    public void deleteAddress(Long id) {

    }
}
