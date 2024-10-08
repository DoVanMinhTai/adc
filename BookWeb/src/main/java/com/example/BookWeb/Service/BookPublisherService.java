package com.example.BookWeb.Service;

import com.example.BookWeb.Model.BookPublisher;
import com.example.BookWeb.Respository.BookPublisherRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookPublisherService {

    private final BookPublisherRespository bookPublisherRespository;

    public BookPublisherService(BookPublisherRespository bookPublisherRespository) {
        this.bookPublisherRespository = bookPublisherRespository;
    }
        public List<BookPublisher> findAll() {
        return bookPublisherRespository.findAll();
        }

}




