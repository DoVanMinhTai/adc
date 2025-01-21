package com.example.book.Service;

import com.example.book.Respository.BookCategoryRepository;

public class CategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    public CategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }
}
