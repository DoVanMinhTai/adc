package com.example.book.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bookreview")
public class BookReview {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String userProfileImage;

    private String comment;

    private BigDecimal ratingPoint;

    private LocalDate creationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @JsonIgnore
    private Book book;


    @JoinColumn(name = "user_id")
    private Long userId;

    // Constructors
    public BookReview() {
    }

    public BookReview(Long id, String name, String userProfileImage, String comment, BigDecimal ratingPoint, LocalDate creationDate, Book book, Long userId) {
        this.id = id;
        this.name = name;
        this.userProfileImage = userProfileImage;
        this.comment = comment;
        this.ratingPoint = ratingPoint;
        this.creationDate = creationDate;
        this.book = book;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(BigDecimal ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}