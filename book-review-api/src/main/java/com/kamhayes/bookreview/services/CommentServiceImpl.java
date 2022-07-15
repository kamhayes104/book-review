package com.kamhayes.bookreview.services;

import com.kamhayes.bookreview.models.Comment;
import com.kamhayes.bookreview.repos.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    @Override
    public List<Comment> findByBookReviewId(int reviewId) {
        return commentRepository.findByBookReviewId(reviewId);
    }

    @Override
    public Comment findByIdAndBookReviewId(int id, int reviewId) {
        return commentRepository.findByIdAndBookReviewId(id, reviewId);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }
}
