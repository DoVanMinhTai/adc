package com.example.BookWeb.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Table(name = "book")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String laguageCode;

    private Float averageRating;
    private String description;
    private Long numPages;

    private Date publishDate;

    private String isbn13;

    private String url;

    private String imageUrl;

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
    private List<BookGenre> bookGenres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formatId", referencedColumnName = "id")
    private BookFormat format;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisherId", referencedColumnName = "id")
    private BookPublisher publisher;

    @OneToMany(mappedBy = "book")
    private List<BookReview> bookReviews;

    public Book(Long id, String laguageCode, Float averageRating, String description, Long numPages, Date publishDate, String isbn13, String url, String imageUrl, Long ratingsCount, String title, String titleWithoutSeries, Double price, Double availability, String dimensions, Float discountPercentage, Double itemWeight, String authorName, List<BookGenre> bookGenres, BookFormat format, BookPublisher publisher, List<BookReview> bookReviews) {
        this.id = id;
        this.laguageCode = laguageCode;
        this.averageRating = averageRating;
        this.description = description;
        this.numPages = numPages;
        this.publishDate = publishDate;
        this.isbn13 = isbn13;
        this.url = url;
        this.imageUrl = imageUrl;
        this.ratingsCount = ratingsCount;
        this.title = title;
        this.titleWithoutSeries = titleWithoutSeries;
        this.price = price;
        this.availability = availability;
        this.dimensions = dimensions;
        this.discountPercentage = discountPercentage;
        this.itemWeight = itemWeight;
        this.authorName = authorName;
        this.bookGenres = bookGenres;
        this.format = format;
        this.publisher = publisher;
        this.bookReviews = bookReviews;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLaguageCode() {
        return laguageCode;
    }

    public void setLaguageCode(String laguageCode) {
        this.laguageCode = laguageCode;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumPages() {
        return numPages;
    }

    public void setNumPages(Long numPages) {
        this.numPages = numPages;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Long ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleWithoutSeries() {
        return titleWithoutSeries;
    }

    public void setTitleWithoutSeries(String titleWithoutSeries) {
        this.titleWithoutSeries = titleWithoutSeries;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<BookGenre> getBookGenres() {
        return bookGenres;
    }

    public void setBookGenres(List<BookGenre> bookGenres) {
        this.bookGenres = bookGenres;
    }

    public BookFormat getFormat() {
        return format;
    }

    public void setFormat(BookFormat format) {
        this.format = format;
    }

    public BookPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(BookPublisher publisher) {
        this.publisher = publisher;
    }

    public List<BookReview> getBookReviews() {
        return bookReviews;
    }

    public void setBookReviews(List<BookReview> bookReviews) {
        this.bookReviews = bookReviews;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", laguageCode='" + laguageCode + '\'' +
                ", averageRating=" + averageRating +
                ", description='" + description + '\'' +
                ", numPages=" + numPages +
                ", publishDate=" + publishDate +
                ", isbn13='" + isbn13 + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", ratingsCount=" + ratingsCount +
                ", title='" + title + '\'' +
                ", titleWithoutSeries='" + titleWithoutSeries + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                ", dimensions='" + dimensions + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", itemWeight=" + itemWeight +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
