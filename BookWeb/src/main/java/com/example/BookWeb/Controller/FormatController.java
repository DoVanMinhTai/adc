package com.example.BookWeb.Controller;

import com.example.BookWeb.Model.BookFormat;
import com.example.BookWeb.Respository.BookFormatRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/format")
public class FormatController {
    private BookFormatRepository bookFormatRepository;
    public FormatController(BookFormatRepository bookFormatRepository) {
        this.bookFormatRepository = bookFormatRepository;
    }
    @PostMapping("/add")
    public BookFormat save(@RequestBody BookFormat bookFormat) {
        return bookFormatRepository.save(bookFormat);
    }
}
