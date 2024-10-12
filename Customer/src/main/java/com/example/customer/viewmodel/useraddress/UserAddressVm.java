package com.example.customer.viewmodel.useraddress;

import com.example.customer.model.UserAddress;
import com.example.customer.viewmodel.address.Address;
import lombok.Builder;

@Builder
public record UserAddressVm (Long id,
                             String userId,
                             Address addressVm, Boolean isActive

                             ){
    public static UserAddressVm fromModel(UserAddress userAddress, Address addressGetVm) {
        return UserAddressVm.builder()
                .id(userAddress.getId())
                .userId(userAddress.getUserId())
                .addressVm(addressGetVm)
                .isActive(userAddress.getIsActive())
                .build();
    }

}
