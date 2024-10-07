package com.example.BookWeb.Service;

import com.example.BookWeb.Mapper.UserMapper;
import com.example.BookWeb.Model.Authority;
import com.example.BookWeb.Model.User;
import com.example.BookWeb.Respository.AuthorityRepository;
import com.example.BookWeb.Respository.UserRespository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRespository userRespository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;
   private final AuthenticationManager authenticationManager;
    public UserService(UserRespository userRespository, UserMapper userMapper, PasswordEncoder passwordEncoder,
                       AuthorityRepository authorityRepository
            , AuthenticationManager authenticationManager
    ) {
        this.userRespository = userRespository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.authenticationManager = authenticationManager;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRespository.findByEmail(email);
    }
    public User updateUser(User user) {
        return userRespository.save(user);
    }
    public Authority getRoleByName(String roleName) {
        return this.authorityRepository.findByName(roleName);
    }
public User saveUser(User user) {
        return userRespository.save(user);
}

public List<User> findAllUser() {
        return this.userRespository.findAll();
}

    public String verify(User user) {

        return "Failed";
    }

    public boolean authenticate(String email, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
            return authentication.isAuthenticated();
        } catch (Exception e) {
            return false;
        }
    }
}
