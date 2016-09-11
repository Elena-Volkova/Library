package com.example.application.server.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
        "id",
        "name",
        "author",
        "publisher",
        "publishYear",
        "pages",
        "availability",
        "library"
})
public class BookDTO {

    private Long id;
    private String name;
    private String author;
    private String publisher;
    private Integer publishYear;
    private Integer pages;
    private boolean availability;
    private LibraryDTO library;

    public BookDTO() {
    }

    private BookDTO(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAuthor(builder.author);
        setPublisher(builder.publisher);
        setPublishYear(builder.publishYear);
        setPages(builder.pages);
        setAvailability(builder.availability);
        setLibrary(builder.library);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public LibraryDTO getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDTO library) {
        this.library = library;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String author;
        private String publisher;
        private Integer publishYear;
        private Integer pages;
        private boolean availability;
        private LibraryDTO library;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
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

        public Builder withPublishYear(Integer val) {
            publishYear = val;
            return this;
        }

        public Builder withPages(Integer val) {
            pages = val;
            return this;
        }

        public Builder withAvailability(boolean val) {
            availability = val;
            return this;
        }

        public Builder withLibrary(LibraryDTO val) {
            library = val;
            return this;
        }

        public BookDTO build() {
            return new BookDTO(this);
        }
    }
}
