package com.kamhayes.bookreview.controllers;

import com.kamhayes.bookreview.models.Book;
import com.kamhayes.bookreview.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable("id") int id) {
        return bookService.findById(id);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        book.setId(0);
        bookService.save(book);
        return book;
    }

    @PutMapping("/books")
    public Book update(@RequestBody Book book) {
        bookService.save(book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        bookService.delete(id);
    }

    @DeleteMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        bookService.deleteAll();
    }
}
