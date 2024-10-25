package com.example.BookWeb.Respository;

import com.example.BookWeb.Model.BookFormat;
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
