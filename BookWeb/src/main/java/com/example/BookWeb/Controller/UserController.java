package com.example.BookWeb.Controller;

import com.example.BookWeb.Model.Authority;
import com.example.BookWeb.Model.User;
import com.example.BookWeb.Respository.AuthorityRepository;
import com.example.BookWeb.Respository.UserRespository;
import com.example.BookWeb.Service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path ="")
public class UserController {
    private final UserService userService;
    private final UserRespository userRespository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService,
                          UserRespository userRespository,
                          AuthorityRepository authorityRepository,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userRespository = userRespository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;

        this.authenticationManager = authenticationManager;

    }


    @Transactional
    @PostMapping("/created")
    public User createUser(@RequestBody User user) {
    String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        // Ensure authorities are correctly assigned
        Authority authority = new Authority();
        authority.setName("ROLE_USER"); // Đảm bảo giá trị này không phải là null
        authority.setUser(user);

        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority);
        user.setAuthority(authorities);
        System.out.println(user.getAuthority());
        return userService.updateUser(user);
    }
    @GetMapping("/abackaa")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }


}
