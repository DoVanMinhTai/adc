package com.example.book.Controller;

import com.example.book.Model.BookReview;
import com.example.book.Service.BookReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/review")
public class BookReviewController {

    private BookReviewService bookReviewService;


    public BookReviewController(BookReviewService bookReviewService) {

        this.bookReviewService = bookReviewService;
    }

    @PostMapping("/add")
    public BookReview add(@RequestBody BookReview bookReview) {
        return bookReviewService.save(bookReview);
    }
}
