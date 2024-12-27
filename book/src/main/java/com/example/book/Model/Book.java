package com.example.book.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "book")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long numPages;
    private boolean isPublished;
    private boolean isVisibleIndividually;
    private Date publishDate;
    private String slug;
    private String isbn13;

    private Long ratingsCount;

    private String title;

    private String titleWithoutSeries;

    private Double price;

    private Double availability;

    private String dimensions;

    private Float discountPercentage;

    private Double itemWeight;

    private String authorName;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<BookCate> bookCate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formatId", referencedColumnName = "id")
    private BookFormat format;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisherId", referencedColumnName = "id")
    private BookPublisher publisher;

    @OneToMany(mappedBy = "book")
    private List<BookRelated> bookRelated = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<BookImage> bookImages = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
