package com.example.book.Service;

import com.example.book.Model.Book;
import com.example.book.Model.BookReview;
import com.example.book.Respository.BookRepository;
import com.example.book.Respository.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookReviewService {
    private final ReviewsRepository  reviewsRepository;
    private final BookRepository  bookRepository;
    public BookReviewService(ReviewsRepository reviewsRepository, BookRepository bookRepository) {
        this.reviewsRepository = reviewsRepository;
        this.bookRepository = bookRepository;
    }
    public BookReview save(BookReview bookReview) {
        if (bookReview.getBook().getBookReviews() == null) {
            bookReview.getBook().setBookReviews(new ArrayList<>());
        }

            Book book = bookRepository.findById(bookReview.getBook().getId()).orElse(null);
            bookReview.setBook(book);


            book.getBookReviews().add(bookReview);
            bookRepository.save(book);

        return reviewsRepository.save(bookReview);
    }
}
