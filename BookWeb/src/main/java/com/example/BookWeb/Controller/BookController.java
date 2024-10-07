package com.example.BookWeb.Controller;



import com.example.BookWeb.Model.Book;
import com.example.BookWeb.Model.BookPublisher;
import com.example.BookWeb.Model.PaginatedItems;
import com.example.BookWeb.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    private  BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
          return ResponseEntity.ok(bookService.saveBook(book));
    }
    public BookPublisher findBookByPublisher(@RequestParam Long id) {
        return bookService.getBookPublisher(id);
    }
    @GetMapping("/books")
    public ResponseEntity<PaginatedItems<Book>> getBooks(
            @RequestParam(defaultValue = "0") int pageIndex
            ,@RequestParam(defaultValue = "10") int pageSize
    ) {
            PaginatedItems<Book> paginaredBooks = bookService.getBooks(pageIndex,pageSize);
            return ResponseEntity.ok(paginaredBooks);
    }
}
