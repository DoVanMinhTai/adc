package com.example.customer.viewmodel.customer;

import org.keycloak.representations.idm.UserRepresentation;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public record CustomerAdminVm(String id, String userName, String email, String firstName, String lastName,
                              LocalDateTime localDateTime) {
    public static CustomerAdminVm fromUserRepresentation(UserRepresentation userRepresentation) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(userRepresentation.getCreatedTimestamp()), TimeZone.getDefault().toZoneId());
        return new CustomerAdminVm(userRepresentation.getId(), userRepresentation.getUsername(), userRepresentation.getEmail(),
                userRepresentation.getFirstName(),  userRepresentation.getLastName(),localDateTime
                );
    }

}
