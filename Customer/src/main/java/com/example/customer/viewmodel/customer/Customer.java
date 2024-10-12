package com.example.customer.viewmodel.customer;

import org.keycloak.representations.idm.UserRepresentation;

public record Customer(String id, String username, String email, String firstName, String lastName) {
    public static Customer fromUserRepresentation(UserRepresentation userRepresentation) {
        return new Customer(userRepresentation.getId(), userRepresentation.getUsername(),
                userRepresentation.getEmail(), userRepresentation.getFirstName(), userRepresentation.getLastName());
    }
}
