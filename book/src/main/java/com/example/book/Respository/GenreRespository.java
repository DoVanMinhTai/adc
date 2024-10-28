package com.example.book.Respository;

import com.example.book.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRespository extends JpaRepository<Genre, Long> {
    List<Genre> findAll();
    Genre save(Genre genre);
    void delete(Genre genre);

}
