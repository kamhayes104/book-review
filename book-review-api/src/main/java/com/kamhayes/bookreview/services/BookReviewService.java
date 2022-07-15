package com.kamhayes.bookreview.services;

import com.kamhayes.bookreview.models.BookReview;

import java.util.List;
import java.util.Optional;

public interface BookReviewService {

    BookReview findById(int id);

    List<BookReview> findByBookId(int id);

    BookReview findByIdAndBookId(int id, int bookId);

    void save(BookReview bookReview);

    void delete(BookReview bookReview);
}
