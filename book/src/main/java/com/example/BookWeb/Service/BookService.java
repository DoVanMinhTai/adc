package com.example.BookWeb.Service;

import com.example.BookWeb.Model.*;
import com.example.BookWeb.Respository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookFormatRepository bookFormatRepository;
    private final BookGenreRespository bookGenreRespository;
    private final BookPublisherRespository bookPublisherRespository;
    private final ReviewsRepository reviewsRepository;
    private final GenreRespository genreRespository;

    public BookService(BookRepository bookRepository, BookFormatRepository bookFormatRepository, BookGenreRespository bookGenreRespository, BookPublisherRespository bookPublisherRespository, ReviewsRepository reviewsRepository, GenreRespository genreRespository) {

        this.bookRepository = bookRepository;
        this.bookFormatRepository = bookFormatRepository;
        this.bookGenreRespository = bookGenreRespository;
        this.bookPublisherRespository = bookPublisherRespository;
        this.reviewsRepository = reviewsRepository;
        this.genreRespository = genreRespository;
    }

    public PaginatedItems<Book> getBooks(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<Book> bookPage = bookRepository.findAll(pageable);

        return new PaginatedItems<>(pageIndex, pageSize, bookPage.getTotalElements(), bookPage.getContent());

    }
    public PaginatedItems<Book> searchBooksByWord(String word, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<Book> bookPage = bookRepository.searchBookByWord(word, pageable);
        return new PaginatedItems<>(pageIndex, pageSize, bookPage.getTotalElements(), bookPage.getContent());
    }

}
