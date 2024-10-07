package com.example.BookWeb.Respository;

import com.example.BookWeb.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRespository extends JpaRepository<Genre, Long> {
    List<Genre> findAll();
    Genre save(Genre genre);
    void delete(Genre genre);

}
