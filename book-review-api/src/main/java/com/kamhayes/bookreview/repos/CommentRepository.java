package com.kamhayes.bookreview.repos;

import com.kamhayes.bookreview.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByBookReviewId(int ReviewId);

    Comment findByIdAndBookReviewId(int id, int reviewId);
}
