package com.example.application.server.repository.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class BookDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publish_year")
    private Integer publishYear;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "receipt_date")
    private Date receiptDate;

    @Column(name = "availability")
    private boolean availability;

    @OneToOne
    @JoinColumn(name = "library_id", insertable = false, updatable = false)
    private LibraryDB library;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
    private UserCardDB userCard;

    public BookDB() {
    }

    private BookDB(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAuthor(builder.author);
        setPublisher(builder.publisher);
        setPublishYear(builder.publishYear);
        setPages(builder.pages);
        setReceiptDate(builder.receiptDate);
        setAvailability(builder.availability);
        setLibrary(builder.library);
        setUserCard(builder.userCard);
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

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public LibraryDB getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDB library) {
        this.library = library;
    }

    public UserCardDB getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCardDB userCard) {
        this.userCard = userCard;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String author;
        private String publisher;
        private Integer publishYear;
        private Integer pages;
        private Date receiptDate;
        private boolean availability;
        private LibraryDB library;
        private UserCardDB userCard;

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

        public Builder withReceiptDate(Date val) {
            receiptDate = val;
            return this;
        }

        public Builder withAvailability(boolean val) {
            availability = val;
            return this;
        }

        public Builder withLibrary(LibraryDB val) {
            library = val;
            return this;
        }

        public Builder withUserCard(UserCardDB val) {
            userCard = val;
            return this;
        }

        public BookDB build() {
            return new BookDB(this);
        }
    }
}
