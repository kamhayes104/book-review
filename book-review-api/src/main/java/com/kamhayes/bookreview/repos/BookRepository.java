package com.kamhayes.bookreview.repos;

import com.kamhayes.bookreview.models.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.function.Function;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public Book findByTitle(String title);
}
