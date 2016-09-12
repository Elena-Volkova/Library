package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tracking", propOrder = {
        "library",
        "user",
        "name",
        "author",
        "publisher",
        "books",
        "userCards"
})
public class TrackingDTO {

    private LibraryDTO library;
    private UserDTO user;
    private String name;
    private String author;
    private String publisher;
    private List<BookDTO> books;
    private List<UserCardDTO> userCards;

    public TrackingDTO() {
    }

    private TrackingDTO(Builder builder) {
        setLibrary(builder.library);
        setUser(builder.user);
        setName(builder.name);
        setAuthor(builder.author);
        setPublisher(builder.publisher);
        setBooks(builder.books);
        setUserCards(builder.userCards);
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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

    public List<UserCardDTO> getUserCards() {
        return userCards;
    }

    public void setUserCards(List<UserCardDTO> userCards) {
        this.userCards = userCards;
    }

    public static final class Builder {
        private LibraryDTO library;
        private UserDTO user;
        private String name;
        private String author;
        private String publisher;
        private List<BookDTO> books;
        private List<UserCardDTO> userCards;

        private Builder() {
        }

        public Builder withLibrary(LibraryDTO val) {
            library = val;
            return this;
        }

        public Builder withUser(UserDTO val) {
            user = val;
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

        public Builder withUserCards(List<UserCardDTO> val) {
            userCards = val;
            return this;
        }

        public TrackingDTO build() {
            return new TrackingDTO(this);
        }
    }
}
