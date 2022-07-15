package com.kamhayes.bookreview.services;

import com.kamhayes.bookreview.models.BookReview;
import com.kamhayes.bookreview.repos.BookReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookReviewServiceImpl implements BookReviewService {

    private final BookReviewRepository bookReviewRepository;

    @Autowired
    public BookReviewServiceImpl(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }


    @Override
    public BookReview findById(int id) {
        Optional<BookReview> attempt = bookReviewRepository.findById(id);
        BookReview bookReview;

        if (attempt.isPresent()) {
            bookReview = attempt.get();
        }
        else {
            throw new RuntimeException("Couldn't find result with that id");
        }
        return bookReview;
    }

    @Override
    public List<BookReview> findByBookId(int id) {
        return bookReviewRepository.findByBookId(id);
    }

    @Override
    public BookReview findByIdAndBookId(int id, int bookId) {
        return bookReviewRepository.findByIdAndBookId(id, bookId);
    }

    @Override
    public void save(BookReview bookReview) {
        bookReviewRepository.save(bookReview);
    }

    @Override
    public void delete(BookReview bookReview) {
        bookReviewRepository.delete(bookReview);
    }
}
