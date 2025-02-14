package com.adc.location.controller;

import com.adc.location.service.StateOrProvinceService;
import com.adc.location.viewmodel.stateorprovince.StateOrProvinceVm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/storefront/state-or-province")
public class StateOrProvinceStoreFrontController {
    private final StateOrProvinceService stateOrProvinceService;

    @GetMapping("/{countryId}")
    public ResponseEntity<List<StateOrProvinceVm>> getStateOrProvinceByCountryId(@PathVariable final Long countryId) {
        return ResponseEntity.ok(stateOrProvinceService.getAllByCountryId(countryId));
    }
}
