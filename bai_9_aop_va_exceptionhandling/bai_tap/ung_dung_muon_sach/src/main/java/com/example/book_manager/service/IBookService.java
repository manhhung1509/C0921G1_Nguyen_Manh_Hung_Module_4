package com.example.book_manager.service;

import com.example.book_manager.model.Book;

public interface IBookService {
    Iterable<Book> findAll();

    Book findById(Long id);

    void save(Book book);
}
