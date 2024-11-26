package com.example.customer.service;

import com.example.customer.model.UserAddress;
import com.example.customer.respository.UserAddressRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAddressService {
    private final UserAddressRespository userAddressRespository;
    public UserAddressService(UserAddressRespository userAddressRespository) {
        this.userAddressRespository = userAddressRespository;
    }
    public List<UserAddress> findAllByUserId(String userID) {
        List<UserAddress> userAddressList = new ArrayList<>();
            for (UserAddress userAddress : userAddressRespository.findAllByUserId(userID)) {
                userAddress.getUserId();
                userAddressList.add(userAddress);
            }
            return userAddressList;
    }
}
