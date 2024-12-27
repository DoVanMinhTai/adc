package com.example.book.viewmodel;

import com.example.book.Model.Book;

public record BookListVM(
        Long id,
        String name,
        String slug
) {
    public static BookListVM fromModel(Book book) {
        return new BookListVM(
                book.getId(), book.getName(), book.getSlug());
    }
}
