package com.example.BookWeb.Respository;

import com.example.BookWeb.Model.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<BookReview,Long> {
    BookReview save(BookReview bookReview);
    void delete(BookReview bookReview);
}