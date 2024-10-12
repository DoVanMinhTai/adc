package com.example.customer.controller;

import com.example.customer.model.UserAddress;
import com.example.customer.service.CustomerService;
import com.example.customer.viewmodel.ErrorVm;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/test1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "OK" ,content = @Content(
                    schema = @Schema(implementation = ErrorVm.class)
                    ))
    })
    public String getCustomer() {
        return "Hello World";
    }

    @GetMapping("/findId")
    public List<UserAddress> findUserAddress() {
        return null;
    }
}
