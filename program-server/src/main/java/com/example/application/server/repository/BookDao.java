package com.example.application.server.repository;

import com.example.application.server.repository.model.BookDB;

import java.util.List;

public interface BookDao {

    List<BookDB> findAllBooks();

    BookDB findById(Long bookId);

    void saveBook(BookDB book);

    void deleteBook(BookDB book);

    void updateBook(BookDB book);

}
