package com.example.customer.controller;

import com.example.customer.model.UserAddress;
import com.example.customer.service.CustomerService;
import com.example.customer.viewmodel.ErrorVm;
import com.example.customer.viewmodel.customer.CustomerPostVm;
import com.example.customer.viewmodel.customer.CustomerVm;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/storefront/customer/profile")
    public ResponseEntity<CustomerVm> getUserProfile() {
        return ResponseEntity.ok(
                customerService.getCustomerProfilce(SecurityContextHolder.getContext().getAuthentication().getName()));
    }
}
