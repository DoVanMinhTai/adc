package com.example.customer.service;

import com.example.customer.respository.UserAddressRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressService {
    private final UserAddressRespository userAddressRespository;
    public UserAddressService(UserAddressRespository userAddressRespository) {
        this.userAddressRespository = userAddressRespository;
    }
}
