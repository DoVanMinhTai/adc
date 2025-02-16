package com.adc.book.controller;




import com.adc.book.model.Book;
import com.adc.book.model.PaginatedItems;
import com.adc.book.service.BookService;
import com.adc.book.viewmodel.BookListGetVM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/controller")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/getBooks")
    public ResponseEntity<PaginatedItems<Book>> getBooks(
            @RequestParam(defaultValue = "0") int pageIndex
            ,@RequestParam(defaultValue = "10") int pageSize
    ) {
            PaginatedItems<Book> paginaredBooks = bookService.getBooks(pageIndex,pageSize);
            return ResponseEntity.ok(paginaredBooks);
    }

    @GetMapping("/search")
    public ResponseEntity<PaginatedItems<Book>> search(@RequestParam(defaultValue = "word") String word,@RequestParam(defaultValue = "0") int pageIndex,@RequestParam(defaultValue = "10") int pageSize) {
        PaginatedItems<Book> paginatedItems = bookService.searchBooksByWord(word,pageIndex,pageSize);
        return ResponseEntity.ok(paginatedItems);
    }

    @GetMapping("/books")
    public ResponseEntity<BookListGetVM> listBooks(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "book-name", defaultValue = "", required = false) String bookName,
            @RequestParam(value = "brand-name", defaultValue = "", required = false) String brandName
    ) {
      return ResponseEntity.ok(bookService.getBooksWithFilter(pageNo,pageSize,bookName,brandName));
    }
    @GetMapping("/book/brand")
    public ResponseEntity<List<Book>> getBookBrand(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "brand-name", defaultValue = "", required = false) String brandName
    ) {
        return ResponseEntity.ok(bookService.getBooksByBrand(brandName ));
    }


}
