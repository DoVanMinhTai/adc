package com.adc.location.service;

import com.adc.location.viewmodel.AddressPostVm;
import com.adc.location.viewmodel.address.AddressGetVm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    public AddressGetVm createAddress(@Valid AddressPostVm dto) {
        
    }
}
