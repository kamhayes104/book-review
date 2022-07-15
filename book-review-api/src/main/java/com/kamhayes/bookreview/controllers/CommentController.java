package com.kamhayes.bookreview.controllers;

import com.kamhayes.bookreview.models.BookReview;
import com.kamhayes.bookreview.models.Comment;
import com.kamhayes.bookreview.services.BookReviewService;
import com.kamhayes.bookreview.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;
    private final BookReviewService bookReviewService;

    public CommentController(CommentService commentService, BookReviewService bookReviewService) {
        this.commentService = commentService;
        this.bookReviewService = bookReviewService;
    }

    @GetMapping("/reviews/{review_id}/comments")
    public List<Comment> findByBookReviewId(@PathVariable("review_id") int reviewId) {
        return commentService.findByBookReviewId(reviewId);
    }

    @PostMapping("/reviews/{review_id}/comments")
    public Comment create(@PathVariable("review_id") int reviewId, @RequestBody Comment comment) {
        BookReview bookReview = bookReviewService.findById(reviewId);
        comment.setId(0);
        comment.setBookReview(bookReview);
        comment.setPublished(LocalDateTime.now());
        commentService.save(comment);
        return comment;
    }

    @PutMapping("/reviews/{review_id}/comments/{comment_id}")
    public void update(@PathVariable("review_id") int reviewId, @PathVariable("comment_id") int commentId,
                       @RequestBody Comment commentRequest) {
        Comment comment = commentService.findByIdAndBookReviewId(commentId, reviewId);
        comment.setContent(commentRequest.getContent());
        commentService.save(comment);
    }

    @DeleteMapping("/reviews/{review_id}/comments/{comment_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable("review_id") int reviewId, @PathVariable("comment_id") int commentId) {
        Comment comment = commentService.findByIdAndBookReviewId(commentId, reviewId);
        commentService.delete(comment);
    }


}
