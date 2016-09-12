package com.example.application.server.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "search", propOrder = {
        "library",
        "name",
        "author",
        "publisher",
        "books"
})
public class BookSearchDTO {

    protected LibraryDTO library;
    protected String name;
    protected String author;
    protected String publisher;
    protected List<BookDTO> books;

    public BookSearchDTO() {}

    private BookSearchDTO(Builder builder) {
        setLibrary(builder.library);
        setName(builder.name);
        setAuthor(builder.author);
        setPublisher(builder.publisher);
        setBooks(builder.books);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public LibraryDTO getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDTO library) {
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    public static final class Builder {
        private LibraryDTO library;
        private String name;
        private String author;
        private String publisher;
        private List<BookDTO> books;

        private Builder() {
        }

        public Builder withLibrary(LibraryDTO val) {
            library = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withAuthor(String val) {
            author = val;
            return this;
        }

        public Builder withPublisher(String val) {
            publisher = val;
            return this;
        }

        public Builder withBooks(List<BookDTO> val) {
            books = val;
            return this;
        }

        public BookSearchDTO build() {
            return new BookSearchDTO(this);
        }
    }
}
