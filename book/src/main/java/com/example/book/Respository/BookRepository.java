package com.example.book.Respository;

import com.example.book.Model.Book;
import com.example.book.Model.Brand;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE title LIKE %:word% OR author_name LIKE %:word%", nativeQuery = true)
    Page<Book> searchBookByWord(@Param("word") String word, Pageable pageable);

    @Query(value = "SELECT b FROM Book b WHERE LOWER(b.name) LIKE %:bookName% "
            + "AND (b.brand.name IN :brandName OR (:brandName is null OR :brandName = '')) " +
            "AND b.isPublished = TRUE " +
            "AND b.isVisibleIndividually = TRUE " +
            "ORDER BY b.id ASC ")
    Page<Book> getBooksWithFilter(@Param("bookName")String bookName,@Param("brandName") String brandName, Pageable pageable);

    List<Book> findAllByBrandAndIsPublishedTrueOrderByIdDesc(Brand brand);

    Optional<Book> findBySlugAndIsPublishedTrue(String slug);
}


