package com.example.book.Respository;

import com.example.book.Model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    public Optional<Brand> findBySlug(String slug);
}
