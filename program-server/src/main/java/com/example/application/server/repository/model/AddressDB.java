package com.example.application.server.repository.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class AddressDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private LibraryDB library;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private UserDB user;

    public AddressDB() {
    }

    private AddressDB(Builder builder) {
        id = builder.id;
        country = builder.country;
        city = builder.city;
        street = builder.street;
        phone = builder.phone;
        library = builder.library;
        user = builder.user;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPhone() {
        return phone;
    }

    public LibraryDB getLibrary() {
        return library;
    }

    public UserDB getUser() {
        return user;
    }

    public static final class Builder {
        private Long id;
        private String country;
        private String city;
        private String street;
        private String phone;
        private LibraryDB library;
        private UserDB user;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withCountry(String val) {
            country = val;
            return this;
        }

        public Builder withCity(String val) {
            city = val;
            return this;
        }

        public Builder withStreet(String val) {
            street = val;
            return this;
        }

        public Builder withPhone(String val) {
            phone = val;
            return this;
        }

        public Builder withLibrary(LibraryDB val) {
            library = val;
            return this;
        }

        public Builder withUser(UserDB val) {
            user = val;
            return this;
        }

        public AddressDB build() {
            return new AddressDB(this);
        }
    }
}
