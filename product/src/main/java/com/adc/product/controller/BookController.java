package com.adc.product.controller;


import com.adc.product.model.Book;
import com.adc.product.model.PaginatedItems;
import com.adc.product.service.BookService;
import com.adc.product.viewmodel.BookListGetVM;
import com.adc.product.viewmodel.BookListVM;
import com.adc.product.viewmodel.ProductGetCheckoutListVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private BookService productService;

    public BookController(BookService bookService) {
        this.productService = bookService;
    }


    @GetMapping("/getBooks")
    public ResponseEntity<PaginatedItems<Book>> getBooks(
            @RequestParam(defaultValue = "0") int pageIndex
            ,@RequestParam(defaultValue = "10") int pageSize
    ) {
            PaginatedItems<Book> paginaredBooks = productService.getBooks(pageIndex,pageSize);
            return ResponseEntity.ok(paginaredBooks);
    }

    @GetMapping("/search")
    public ResponseEntity<PaginatedItems<Book>> search(@RequestParam(defaultValue = "word") String word,@RequestParam(defaultValue = "0") int pageIndex,@RequestParam(defaultValue = "10") int pageSize) {
        PaginatedItems<Book> paginatedItems = productService.searchBooksByWord(word,pageIndex,pageSize);
        return ResponseEntity.ok(paginatedItems);
    }

    @GetMapping("/books")
    public ResponseEntity<BookListGetVM> listBooks(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "book-name", defaultValue = "", required = false) String bookName,
            @RequestParam(value = "brand-name", defaultValue = "", required = false) String brandName
    ) {
      return ResponseEntity.ok(productService.getBooksWithFilter(pageNo,pageSize,bookName,brandName));
    }
    @GetMapping("/book/brand")
    public ResponseEntity<List<Book>> getBookBrand(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "brand-name", defaultValue = "", required = false) String brandName
    ) {
        return ResponseEntity.ok(productService.getBooksByBrand(brandName ));
    }
    @GetMapping("/products")
    public ResponseEntity<ProductGetCheckoutListVm> getProductCheckoutList(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "20", required = false) int pageSize,
            @RequestParam(value = "ids", required = false) List<Long> productIds) {
        return ResponseEntity.ok(productService.getProductCheckoutList(pageNo, pageSize, productIds));
    }

    @GetMapping("/productsBestSelling")
    public ResponseEntity<List<BookListVM>>  getProductBestSelling(){
        return ResponseEntity.ok(productService.getProductByIdAndCompleted());
    }


}
