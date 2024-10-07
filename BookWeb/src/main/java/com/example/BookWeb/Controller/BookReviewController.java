package com.example.BookWeb.Controller;

import com.example.BookWeb.Model.BookReview;
import com.example.BookWeb.Respository.ReviewsRepository;
import com.example.BookWeb.Service.BookReviewService;
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
