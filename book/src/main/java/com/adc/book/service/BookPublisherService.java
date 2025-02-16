package com.adc.book.service;

import com.adc.book.model.BookPublisher;
import com.adc.book.respository.BookPublisherRespository;
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




