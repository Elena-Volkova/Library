package com.example.application.server.repository.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class LibraryDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressDB address;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "library")
    private BookDB book;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "library")
    private UserDB user;

    public LibraryDB() {
    }

    private LibraryDB(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAddress(builder.address);
        setBook(builder.book);
        setUser(builder.user);
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

    public AddressDB getAddress() {
        return address;
    }

    public void setAddress(AddressDB address) {
        this.address = address;
    }

    public BookDB getBook() {
        return book;
    }

    public void setBook(BookDB book) {
        this.book = book;
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private AddressDB address;
        private BookDB book;
        private UserDB user;

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

        public Builder withAddress(AddressDB val) {
            address = val;
            return this;
        }

        public Builder withBook(BookDB val) {
            book = val;
            return this;
        }

        public Builder withUser(UserDB val) {
            user = val;
            return this;
        }

        public LibraryDB build() {
            return new LibraryDB(this);
        }
    }
}
