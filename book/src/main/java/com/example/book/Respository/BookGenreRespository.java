package com.example.book.Respository;

import com.example.book.Model.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookGenreRespository extends JpaRepository<BookGenre, Long> {
    BookGenre save(BookGenre bookGenre);
    void delete(BookGenre entity);
}
