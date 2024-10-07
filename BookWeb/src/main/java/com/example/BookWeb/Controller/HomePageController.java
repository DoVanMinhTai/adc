package com.example.BookWeb.Controller;

import com.example.BookWeb.Model.Book;
import com.example.BookWeb.Model.User;
import com.example.BookWeb.Service.BookService;
import com.example.BookWeb.Service.UserService;
import com.example.BookWeb.dto.UserCreationDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homepage")
public class HomePageController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final BookService bookService;
    public HomePageController(UserService userService, PasswordEncoder passwordEncoder, BookService bookService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.bookService = bookService;
    }


}
