package com.adc.product.service;

import com.adc.commonlibrary.exception.NotFoundException;
import com.adc.product.model.*;
import com.adc.product.respository.*;

import com.adc.product.viewmodel.*;
import io.micrometer.common.util.StringUtils;
//import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.CollectionUtils;

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

    public ProductFeaturedGetVm getFeaturedProduct(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<ProductThumbnailGetVm> productThumbnailGetVms = new ArrayList<>();
        Page<Book> productPage = bookRepository.getFeaturedProducts(pageable);
        List<Book> productList = productPage.getContent();
        for (Book book : productList) {
            productThumbnailGetVms.add(
                    new ProductThumbnailGetVm(
                            book.getId(),book.getName(),book.getSlug()
                            ,mediaService.getMedia(book.getThumbnailMediaId()).url(),book.getPrice()
                    )
            );
        }
        return new ProductFeaturedGetVm(productThumbnailGetVms,productPage.getTotalPages() );

    }

    public ProductDetailGetVm getProductDetail(String slug) {
        Book product = bookRepository.findBySlugAndIsPublishedTrue(slug).orElseThrow(
                () -> new NotFoundException("Not Found For" ,slug)
        );
        String thumbnailMediaUrl = mediaService.getMedia(product.getThumbnailMediaId()).url();
        List<String> productImageMediaUrl = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(product.getBookImages())) {
            for (BookImage image : product.getBookImages()) {
                productImageMediaUrl.add(mediaService.getMedia(image.getImageId()).url());
            }
        }

//        List<String> productCategories = bookCategoryRepository.findById(product.getId());
        return new ProductDetailGetVm(
                product.getId(),
                product.getName(),
                product.getBrand().getName(),
                product.getBookCate().stream().map(category -> category.getCate().getName()).toList(),
                product.getShorTDescription(),
                product.getDescription(),
                product.getSpecification(),
                product.isPublished(),
                product.isFeatured(),
                product.isAllowedToOrder(),
                product.getPrice(),
                thumbnailMediaUrl,
                productImageMediaUrl);
    }
}
