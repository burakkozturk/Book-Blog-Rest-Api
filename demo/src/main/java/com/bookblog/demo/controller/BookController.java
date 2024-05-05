package com.bookblog.demo.controller;

import com.bookblog.demo.dto.BookDto;
import com.bookblog.demo.entity.Book;
import com.bookblog.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long bookId){
        Optional<Book> book = bookService.getBookById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Book> saveBook (@RequestBody BookDto bookDto){
        Book book = bookService.saveBook(bookDto);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/{bookId}")
    public Optional<ResponseEntity<Optional<Book>>> updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto){
        Optional<Book> optionalBook = bookService.updateBook(bookId,bookDto);
        return optionalBook.map(value -> new ResponseEntity<>(optionalBook, HttpStatus.OK));
    }

    @DeleteMapping("/{bookId}")
    public void removeBook(@PathVariable Long bookId){
        bookService.removeBook(bookId);
    }

    @DeleteMapping("/all")
    public void removeAllBook(){
        bookService.removeAllBooks();
    }



}
