package com.adc.book.respository;

import com.adc.book.model.BookCate;
import com.adc.book.model.Cate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCategoryRepository extends JpaRepository<Cate, Long> {
//    Page<BookCate> findAllByCategory(Pageable pageable, Cate category);

//    List<BookCate> findAllByBookId(Long productId);
}
