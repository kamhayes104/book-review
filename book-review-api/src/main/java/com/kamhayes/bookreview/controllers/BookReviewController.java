package com.kamhayes.bookreview.controllers;

import com.kamhayes.bookreview.models.Book;
import com.kamhayes.bookreview.models.BookReview;
import com.kamhayes.bookreview.services.BookReviewService;
import com.kamhayes.bookreview.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookReviewController {

    private final BookReviewService bookReviewService;
    private final BookService bookService;

    public BookReviewController(BookReviewService bookReviewService, BookService bookService) {
        this.bookReviewService = bookReviewService;
        this.bookService = bookService;
    }


    @GetMapping("/reviews/{id}")
    public BookReview findById(@PathVariable("id") int id) {
        return bookReviewService.findById(id);
    }

    @GetMapping("/books/{book_id}/reviews")
    public List<BookReview> findByBookId(@PathVariable("book_id") int bookId) {
            return bookReviewService.findByBookId(bookId);
    }

    @PostMapping("/books/{book_id}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public BookReview create(@PathVariable("book_id") int bookId, @RequestBody BookReview bookReview) {
        Book book = bookService.findById(bookId);
        bookReview.setId(0);
        bookReview.setBook(book);
        bookReview.setPublished(LocalDateTime.now());
        bookReviewService.save(bookReview);
        return bookReview;
    }

    @PutMapping("/books/{book_id}/reviews/{review_id}")
    public void update(@PathVariable("book_id") int bookId, @PathVariable("review_id") int reviewId,
                       @RequestBody BookReview reviewRequest) {
        BookReview review = bookReviewService.findByIdAndBookId(reviewId, bookId);
        review.setContent(reviewRequest.getContent());
        bookReviewService.save(review);
    }

    @DeleteMapping("/books/{book_id}/reviews/{review_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("book_id") int bookId, @PathVariable("review_id") int reviewId) {
        BookReview review = bookReviewService.findByIdAndBookId(reviewId, bookId);
        bookReviewService.delete(review);
    }
}
