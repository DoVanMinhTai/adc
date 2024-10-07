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

       public List<Book> getAllBook() {
        return bookRepository.findAll();
    }


    public Book saveBook(Book book) {
        if (book.getFormat() != null && book.getFormat().getId() != null) {

            BookFormat existingFormat = bookFormatRepository.findById(book.getFormat().getId()).orElse(null);
            if (existingFormat != null) {
                book.setFormat(existingFormat);

            }
        } else {
            book.getFormat().setBook(book);
        }
        // Xử lý BookPublisher
        if (book.getPublisher() != null && book.getPublisher().getId() != null) {
            BookPublisher existingPublisher = bookPublisherRespository.findById(book.getPublisher().getId()).orElse(null);
            if (existingPublisher != null) {
                book.setPublisher(existingPublisher);
            }
        }

        // Xử lý BookReview
        if (book.getBookReviews() != null) {
            for (BookReview review : book.getBookReviews()) {
                if (review.getId() != null) {
                    BookReview existingReview = reviewsRepository.findById(review.getId()).orElse(null);
                    if (existingReview != null) {
                        review.setBook(book);
                    } else {
                        review.setBook(book);
                    }
                } else {
                    review.setBook(book);
                }
            }
        }
        if (book.getBookGenres() != null) {
            for (BookGenre bookGenre : book.getBookGenres()) {
                if (bookGenre.getGenre() != null && bookGenre.getGenre().getId() != null) {
                    Genre genreId = genreRespository.findById(bookGenre.getGenre().getId()).orElse(null);
                    bookGenre.setGenre(genreId);
                }
                bookGenre.setBook(book);
            }
        }
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookPublisher getBookPublisher(Long id) {
        return bookPublisherRespository.findById(id).orElse(null);
    }

    public PaginatedItems<Book> getBooks(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<Book> bookPage = bookRepository.findAll(pageable);

        return new PaginatedItems<>(pageIndex, pageSize, bookPage.getTotalElements(), bookPage.getContent());

    }
}
