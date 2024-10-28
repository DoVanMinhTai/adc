package com.example.book.Respository;

import com.example.book.Model.BookFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookFormatRepository extends JpaRepository<BookFormat, Long> {
    BookFormat save(BookFormat bookFormat);
    void delete(BookFormat bookFormat);
    Optional<BookFormat> findById(Long id);
}
