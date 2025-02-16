package com.adc.book.respository;

import com.adc.book.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    public Optional<Brand> findBySlug(String slug);
}
