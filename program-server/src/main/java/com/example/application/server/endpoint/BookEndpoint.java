package com.example.application.server.endpoint;

import com.example.application.server.model.action.*;
import com.example.application.server.repository.BookDao;
import com.example.application.server.repository.LibraryDao;
import com.example.application.server.repository.model.BookDB;
import com.example.application.server.util.BookBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/application/server/model";

    private final BookDao bookDao;

    private final LibraryDao libraryDao;

    @Autowired
    public BookEndpoint(BookDao bookDao, LibraryDao libraryDao) {
        this.bookDao = bookDao;
        this.libraryDao = libraryDao;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveBookRequest")
    @ResponsePayload
    @Transactional
    public SaveBookResponse saveBookRequest(@RequestPayload SaveBookRequest request) {
        SaveBookResponse response = new SaveBookResponse();
        BookDB book = BookBuilderUtil.convertBookToBookDB(request.getBook());
        bookDao.saveBook(book);
        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBookRequest")
    @ResponsePayload
    @Transactional
    public UpdateBookResponse updateBookRequest(@RequestPayload UpdateBookRequest request) {
        UpdateBookResponse response = new UpdateBookResponse();
        BookDB book = bookDao.findById(request.getBook().getId());
        BookBuilderUtil.mergeBookWithBookDB(book, request.getBook());
        book.setLibrary(libraryDao.findById(request.getBook().getLibrary().getId()));
        bookDao.updateBook(book);

        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBookRequest")
    @ResponsePayload
    @Transactional
    public DeleteBookResponse deleteBookRequest(@RequestPayload DeleteBookRequest request) {
        BookDB book = bookDao.findById(request.getBookId());
        bookDao.deleteBook(book);
        DeleteBookResponse response = new DeleteBookResponse();
        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookByIdRequest")
    @ResponsePayload
    @Transactional
    public GetBookByIdResponse getBookByIdRequest(@RequestPayload GetBookByIdRequest request) {
        GetBookByIdResponse response = new GetBookByIdResponse();
        BookDB book = bookDao.findById(request.getBookId());
        response.setBook(BookBuilderUtil.convertBookDBToBook(book));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBooksRequest")
    @ResponsePayload
    @Transactional
    public GetBooksResponse getBooksRequest(@RequestPayload GetBooksRequest request) {
        GetBooksResponse response = new GetBooksResponse();
        List<BookDB> books = bookDao.findAllBooks();
        response.setBooks(books.stream()
                .map(BookBuilderUtil::convertBookDBToBook)
                .collect(Collectors.toList())
        );
        return response;
    }
}
