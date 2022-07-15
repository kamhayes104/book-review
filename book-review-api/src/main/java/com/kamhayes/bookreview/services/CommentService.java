package com.kamhayes.bookreview.services;

import com.kamhayes.bookreview.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    public List<Comment> findByBookReviewId(int reviewId);

    Comment findByIdAndBookReviewId(int id, int reviewId);

    public void save(Comment comment);

    public void delete(Comment comment);

}
