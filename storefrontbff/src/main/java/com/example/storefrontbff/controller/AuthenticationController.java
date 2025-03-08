package com.example.storefrontbff.controller;

import com.example.storefrontbff.viewmodel.AuthenticatedIUserVm;
import com.example.storefrontbff.viewmodel.AuthenticatedInforVm;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
    @GetMapping("/authentication")
    public ResponseEntity<AuthenticatedInforVm> user(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return ResponseEntity.ok(new AuthenticatedInforVm(false, null));
        }
        AuthenticatedIUserVm authenticatedUser = new AuthenticatedIUserVm(principal.getAttribute("preferred_username"));
        return ResponseEntity.ok(new AuthenticatedInforVm(true, authenticatedUser));
    }
}
