package com.example.application.server.util;

import com.example.application.server.model.BookDTO;
import com.example.application.server.repository.model.BookDB;
import org.springframework.stereotype.Component;

@Component
public class BookBuilderUtil {

    public static BookDB convertBookToBookDB(BookDTO book) {
        return BookDB.newBuilder()
                .withId(book.getId())
                .withAuthor(book.getAuthor())
                .withName(book.getName())
                .withPublisher(book.getPublisher())
                .withPublishYear(book.getPublishYear())
                .withPages(book.getPages())
                .withAvailability(book.isAvailability())
                .withLibrary(LibraryBuilderUtil.convertLibraryToLibraryDB(book.getLibrary()))
                .build();
    }

    public static BookDTO convertBookDBToBook(BookDB book) {
        if (book == null){
            return null;
        } else {
            return BookDTO.newBuilder()
                    .withId(book.getId())
                    .withAuthor(book.getAuthor())
                    .withName(book.getName())
                    .withPublisher(book.getPublisher())
                    .withPublishYear(book.getPublishYear())
                    .withPages(book.getPages())
                    .withAvailability(book.isAvailability())
                    .withLibrary(LibraryBuilderUtil.convertLibraryDBToLibrary(book.getLibrary()))
                    .build();
        }
    }

    public static void mergeBookWithBookDB(BookDB bookDB, BookDTO bookDTO) {
        bookDB.setAuthor(bookDTO.getAuthor());
        bookDB.setName(bookDTO.getName());
        bookDB.setPublisher(bookDTO.getPublisher());
        bookDB.setPages(bookDTO.getPages());
        bookDB.setAvailability(bookDTO.isAvailability());
    }
}
