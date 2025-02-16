package com.adc.book.model;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "product_related")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookRelated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "related_book_id")
    private Book book_related;
}
