package com.example.customer.service;

import com.example.customer.config.KeyCloakPropsConfig;
import com.example.customer.viewmodel.customer.CustomerPostVm;
import com.example.customer.viewmodel.customer.CustomerVm;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private static final String ERROR =  "%s: Client %s don't have access right for this resource";
    private static final int USER_PAGE =2;
    private final Keycloak keycloak;
    private final KeyCloakPropsConfig keyCloakPropsConfig;


    public CustomerService(Keycloak keycloak, KeyCloakPropsConfig keyCloakPropsConfig) {
        this.keycloak = keycloak;
        this.keyCloakPropsConfig = keyCloakPropsConfig;
    }

    public static CredentialRepresentation credentialRepresentation(String password) {
        CredentialRepresentation passwordCredential = new CredentialRepresentation();
        passwordCredential.setTemporary(false);
        passwordCredential.setType(CredentialRepresentation.PASSWORD);
        passwordCredential.setValue(password);
        return passwordCredential;
    }
    private boolean checkUsernameExists(RealmResource realmResource,String username) {
        List<UserRepresentation> users = realmResource.users().search(username,true);
        return !users.isEmpty();
    }
    private boolean checkEmailExists(RealmResource realmResource,String email) {
        List<UserRepresentation> users = realmResource.users().search(null,null,null,email,0,1);
        return !users.isEmpty();
    }

//    public CustomerVm create(CustomerPostVm customerPostVm) {
//        RealmResource realmResource = keycloak.realm(keyCloakPropsConfig.getRealm());
//        if(checkUsernameExists(realmResource, customerPostVm.userName())) {
//            throw
//        }
//    }
}
