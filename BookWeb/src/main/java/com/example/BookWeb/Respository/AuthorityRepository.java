package com.example.BookWeb.Respository;

import com.example.BookWeb.Model.Authority;
import com.example.BookWeb.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);
    List<Authority> findAll();
    Authority save(Authority authority);
    User save(User user);
}
