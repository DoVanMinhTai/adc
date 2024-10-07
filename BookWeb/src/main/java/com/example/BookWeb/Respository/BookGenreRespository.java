package com.example.BookWeb.Respository;

import com.example.BookWeb.Model.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookGenreRespository extends JpaRepository<BookGenre, Long> {
    BookGenre save(BookGenre bookGenre);
    void delete(BookGenre entity);
}
