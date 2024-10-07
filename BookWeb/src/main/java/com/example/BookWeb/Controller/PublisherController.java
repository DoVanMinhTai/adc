package com.example.BookWeb.Controller;


import com.example.BookWeb.Model.BookPublisher;
import com.example.BookWeb.Respository.BookPublisherRespository;
import com.example.BookWeb.Service.BookPublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PublisherController {
    private BookPublisherRespository bookPublisherRespository;
    private final BookPublisherService bookPublisherService;

    public PublisherController(BookPublisherService bookPublisherService) {
        this.bookPublisherService = bookPublisherService;
    }


    @PostMapping("/addPublisher")
    public BookPublisher save(@RequestBody BookPublisher bookPublisher) {
        return bookPublisherRespository.save(bookPublisher);
    }
    @GetMapping("/findAllBookByPulisher")
    public List<BookPublisher> findAllBookByPulisher() {
        return bookPublisherService.findAll();
    }
}
