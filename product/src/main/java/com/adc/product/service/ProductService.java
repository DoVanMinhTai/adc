package com.adc.product.service;

import com.adc.product.model.*;
import com.adc.product.respository.*;

import com.adc.product.viewmodel.*;
import io.micrometer.common.util.StringUtils;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final BookRepository bookRepository;
    private final BookCategoryRepository bookCategoryRepository;
    private final BookPublisherRespository bookPublisherRespository;
    private final GenreRespository genreRespository;
    private final BrandRepository brandRepository;
    private final OrderService orderService;
    private final MediaService mediaService;


    public PaginatedItems<Book> getBooks(int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<Book> bookPage = bookRepository.findAll(pageable);

        return new PaginatedItems<>(pageIndex, pageSize, bookPage.getTotalElements(), bookPage.getContent());

    }

    public PaginatedItems<Book> searchBooksByWord(String word, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<Book> bookPage = bookRepository.searchBookByWord(word, pageable);
        return new PaginatedItems<>(pageIndex, pageSize, bookPage.getTotalElements(), bookPage.getContent());
    }

    public BookListGetVM getBooksWithFilter(int pageNo, int pageSize, String bookName, String brand) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Book> bookPage;
        bookPage = bookRepository.getBooksWithFilter(bookName.trim().toLowerCase(), brand.trim(), pageable);
        List<Book> bookList = bookPage.getContent();
        List<BookListVM> bookListVMS = bookList.stream().map(BookListVM::fromModel).toList();

        return new BookListGetVM(bookListVMS,bookPage.getNumber(),bookPage.getSize(),
                (int)   bookPage.getTotalElements(),bookPage.getTotalPages()
                   ,bookPage.isLast() );
    }
    public List<Book> getBooksByBrand(String brandSlug) {
        List<Book> result = new ArrayList<>();
        Brand brand = brandRepository.findBySlug(brandSlug).orElseThrow(() -> new NotFoundException("Not Found For" + brandSlug));
        List<Book> books = bookRepository.findAllByBrandAndIsPublishedTrueOrderByIdDesc(brand);
        result.addAll(books);
        return result;
    }


    public ProductGetCheckoutListVm getProductCheckoutList(int pageNo, int pageSize, List<Long> productIds) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Book> productPage = bookRepository.findAllPublishedProductsByIds(productIds, pageable);

        List<ProductCheckoutListVm> productCheckoutListVms = productPage.getContent()
                .stream().map(product -> {
//                    String thumbnailUrl = mediaService.getMedia(product.getThumbnailMediaId()).url();
                    ProductCheckoutListVm productCheckoutListVm = ProductCheckoutListVm.fromModel(product);
//                    if (StringUtils.isNotEmpty(thumbnailUrl)) {
//                        return productCheckoutListVm.toBuilder().thumbnailUrl(thumbnailUrl).build();
//                    }
                    return productCheckoutListVm;
                }).toList();
        return new ProductGetCheckoutListVm(
                productCheckoutListVms,
                productPage.getNumber(),
                productPage.getSize(),
                (int) productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isLast()
        );
    }
    public List<ProductThumbnailGetVm> getProductBestSelling() {
        List<Long> productIds = orderService.getProductByIdAndCompleted();
        List<Book> result = bookRepository.findAllById(productIds);
        return result.stream().map(
                product -> {
                    String thumbnail = mediaService.getMedia(product.getThumbnailMediaId()).url();
                    System.out.println("here" +thumbnail);
                    return new ProductThumbnailGetVm(
                                product.getId(),
                                product.getName(),
                                product.getSlug(),
                                thumbnail,
                                product.getPrice()
                        );

                }
        ).toList();
    }
}
