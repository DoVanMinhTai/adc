package com.example.book.Respository;

import com.example.book.Model.BookCate;
import com.example.book.Model.Cate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Cate, Long> {


}
