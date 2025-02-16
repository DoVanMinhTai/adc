package com.adc.book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "book_cate")
public class BookCate {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "book_id",nullable = false)
    @JsonIgnore
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "cate_id",nullable = false)
    private Cate cate;

    public BookCate(long id, Book book, Cate cate) {
        this.id = id;
        this.book = book;
        this.cate = cate;
    }

    public BookCate() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Cate getGenre() {
        return cate;
    }

    public void setGenre(Cate cate) {
        this.cate = cate;
    }
}
