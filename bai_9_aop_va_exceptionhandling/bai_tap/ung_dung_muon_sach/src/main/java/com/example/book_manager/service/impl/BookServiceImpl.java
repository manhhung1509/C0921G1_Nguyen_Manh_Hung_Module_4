package com.example.book_manager.service.impl;

import com.example.book_manager.model.Book;
import com.example.book_manager.repository.BookRepository;
import com.example.book_manager.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Iterable<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }
}
