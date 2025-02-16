package com.adc.book.service;

import com.adc.book.respository.BookCategoryRepository;

public class CategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    public CategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }
}
