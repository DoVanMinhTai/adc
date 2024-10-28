package com.example.book.Respository;

import com.example.book.Model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE title LIKE %:word% OR author_name LIKE %:word%", nativeQuery = true)
    Page<Book> searchBookByWord(@Param("word") String word, Pageable pageable);


    Page<Book> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM book b where b.id=:id",nativeQuery = true)
    Book getBookById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.title = :title, b.authorName = :author, b.laguageCode = :languageCode WHERE b.id = :id")
    void updateBook(@Param("id") Long id, @Param("title") String title, @Param("author") String author, @Param("languageCode") String languageCode);

    @Query(value = "SELECT b.laguageCode from Book b")
    List<String> getLanguageCode();

}


