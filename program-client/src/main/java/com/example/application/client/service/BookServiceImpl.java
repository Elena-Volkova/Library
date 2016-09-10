package com.example.application.client.service;

import com.example.application.client.endpoint.ServiceWSClient;
import com.example.application.client.service.model.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private ServiceWSClient serviceWSClient;

    @Autowired
    public BookServiceImpl(ServiceWSClient serviceWSClient) {
        this.serviceWSClient = serviceWSClient;
    }

    @Override
    public void add(BookDTO book) {
        serviceWSClient.saveBook(book);
    }

    @Override
    public void update(BookDTO book) {
        serviceWSClient.updateBook(book);
    }

    @Override
    public void delete(Long bookId) {
        serviceWSClient.deleteBook(bookId);
    }

    @Override
    public BookDTO getBook(Long bookId) {
        return serviceWSClient.getBookById(bookId).getBook();
    }

    @Override
    public List<BookDTO> getBooks() {
        return serviceWSClient.getBooks().getBooks();
    }
}
