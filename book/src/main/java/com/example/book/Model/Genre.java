package com.example.book.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {


   @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private List<BookGenre> genre;

    public Genre(Long id, String name, List<BookGenre> genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Genre() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookGenre> getGenre() {
        return genre;
    }

    public void setGenre(List<BookGenre> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                '}';
    }
}
