package com.example.BookWeb.Controller;

import com.example.BookWeb.Model.Genre;
import com.example.BookWeb.Respository.GenreRespository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    GenreRespository genreRepository;
    public GenreController(GenreRespository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/findAll")
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
    @PostMapping("/save")
    public Genre save(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Genre genre) {
        genreRepository.delete(genre);
    }
}


