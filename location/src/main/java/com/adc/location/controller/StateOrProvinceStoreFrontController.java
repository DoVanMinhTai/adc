package com.adc.location.controller;

import com.adc.location.service.StateOrProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StateOrProvinceStoreFrontController {
    private final StateOrProvinceService stateOrProvinceService;

    @GetMapping
}
