package com.kamhayes.bookreview.services;

import com.kamhayes.bookreview.models.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findById(int id);

    public Book findByTitle(String title);

    public void save(Book book);

    public void delete(int id);

    public void deleteAll();
}
