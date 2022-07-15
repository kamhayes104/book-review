package com.kamhayes.bookreview.repos;

import com.kamhayes.bookreview.models.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {

    List<BookReview> findByBookId(int id);

    BookReview findByIdAndBookId(int id, int bookId);
}
