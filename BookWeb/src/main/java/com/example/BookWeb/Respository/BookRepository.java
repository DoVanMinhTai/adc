package com.example.BookWeb.Respository;

import com.example.BookWeb.Model.Book;
import com.example.BookWeb.Model.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
   // @Query(value = "SELECT * FROM book WHERE ratings_count > 1700", nativeQuery = true)
    List<Book> findAll();


    Book getById(Integer id);

   Book save(Book book);

    void deleteById(Long id);
    Optional<Book> findById(Long id);

    //    List<Book> findAllByPublisherOr(String author);

}
