package com.example.application.client.service;

import com.example.application.client.service.model.BookDTO;

import java.util.List;

public interface BookService {

    void add(BookDTO book);

    void update(BookDTO book);

    void delete(Long bookId);

    BookDTO getBook(Long bookId);

    List<BookDTO> getBooks();
}
