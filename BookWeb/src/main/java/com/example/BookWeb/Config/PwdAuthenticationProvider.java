package com.example.BookWeb.Config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PwdAuthenticationProvider implements AuthenticationProvider {


  private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public PwdAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;

        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
       UserDetails user = userDetailsService.loadUserByUsername(username);

        if (passwordEncoder.matches(pwd, user.getPassword())) {
            // Fetch Age details and perform validation to check if age >18

            return  new UsernamePasswordAuthenticationToken(username, pwd,user.getAuthorities());
            //   authToken;
        } else {
            throw new BadCredentialsException("Invalid password!");
        }
    }






    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}

