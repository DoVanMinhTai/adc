package com.adc.location.controller;

import com.adc.location.service.AddressService;
import com.adc.location.viewmodel.address.AddressDetailVm;
import com.adc.location.viewmodel.address.AddressPostVm;
import com.adc.location.viewmodel.address.AddressGetVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/storefront/addresses")
    public ResponseEntity<AddressGetVm> createAddress(@Valid @RequestBody AddressPostVm dto) {
        return ResponseEntity.ok(addressService.createAddress(dto));
    }
    @PutMapping("/storefront/addresses/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable Long id, @Valid @RequestBody AddressPostVm dto) {
        addressService.updateAddress(id,dto);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/storefront/addresses/{id}")
    public ResponseEntity<AddressDetailVm> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }
    @GetMapping("/storefront/addresses")
    public ResponseEntity<List<AddressDetailVm>> getAddressList(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(addressService.getAddressList(ids));
    }

    @DeleteMapping("/storefront/addresses/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok().build();
    }
}
