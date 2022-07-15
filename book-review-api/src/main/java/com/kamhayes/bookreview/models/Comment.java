package com.kamhayes.bookreview.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user")
    private String user;

    @Column(name = "content")
    private String content;

    @Column(name = "published")
    private LocalDateTime published;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "book_review_id", nullable = false)
    private BookReview bookReview;

    public Comment() {}

    public Comment(int id, String user, String content) {
        this.id = id;
        this.user = user;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BookReview getBookReview() {
        return bookReview;
    }

    public void setBookReview(BookReview bookReview) {
        this.bookReview = bookReview;
    }

    public LocalDateTime getPublished() {
        return published;
    }

    public void setPublished(LocalDateTime published) {
        this.published = published;
    }
}
