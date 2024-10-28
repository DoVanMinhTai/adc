package com.example.book.Controller;


import com.example.book.Model.BookPublisher;
import com.example.book.Respository.BookPublisherRespository;
import com.example.book.Service.BookPublisherService;
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
