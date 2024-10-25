package com.example.BookWeb.Controller;



import com.example.BookWeb.Model.Book;
import com.example.BookWeb.Model.BookPublisher;
import com.example.BookWeb.Model.PaginatedItems;
import com.example.BookWeb.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/controller")
public class BookController {
    private  BookService bookService;

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

}
