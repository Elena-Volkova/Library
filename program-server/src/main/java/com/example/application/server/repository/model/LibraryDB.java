package com.example.application.server.repository.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library")
public class LibraryDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressDB address;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "libraries", cascade = CascadeType.ALL)
    private List<BookDB> books = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "libraries", cascade = CascadeType.ALL)
    private List<UserDB> users = new ArrayList<>();

    public LibraryDB() {
    }

    private LibraryDB(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAddress(builder.address);
        setBooks(builder.books);
        setUsers(builder.users);
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

    public List<BookDB> getBooks() {
        return books;
    }

    public void setBooks(List<BookDB> books) {
        this.books = books;
    }

    public List<UserDB> getUsers() {
        return users;
    }

    public void setUsers(List<UserDB> users) {
        this.users = users;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private AddressDB address;
        private List<BookDB> books;
        private List<UserDB> users;

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

        public Builder withBooks(List<BookDB> val) {
            books = val;
            return this;
        }

        public Builder withUsers(List<UserDB> val) {
            users = val;
            return this;
        }

        public LibraryDB build() {
            return new LibraryDB(this);
        }
    }
}
