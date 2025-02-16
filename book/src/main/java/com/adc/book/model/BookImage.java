package com.adc.book.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "book_image")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

}
