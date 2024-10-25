package com.example.customer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Setter
@Configuration
@ConfigurationProperties(value = "keycloak")
public class KeyCloakPropsConfig {
    private String authServerURL;
    private String realm;
    private String resource;
    private Credentials credentials = new Credentials();

    public String getAuthServerURL() {
        return authServerURL;
    }

    public void setAuthServerURL(String authServerURL) {
        this.authServerURL = authServerURL;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }



    @Getter
    @Setter
    public class Credentials {
        private String secret;

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }
    }
    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
