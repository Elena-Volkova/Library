package com.example.application.server.repository.model;

import com.example.application.server.model.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToOne
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private AddressDB address;

    @OneToOne
    @JoinColumn(name = "library_id", insertable = false, updatable = false)
    private LibraryDB library;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserCardDB userCard;

    public UserDB() {
    }

    private UserDB(Builder builder) {
        setId(builder.id);
        setLogin(builder.login);
        setPassword(builder.password);
        setRole(builder.role);
        setName(builder.name);
        setSurname(builder.surname);
        setPatronymic(builder.patronymic);
        setAddress(builder.address);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public AddressDB getAddress() {
        return address;
    }

    public void setAddress(AddressDB address) {
        this.address = address;
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
        private String login;
        private String password;
        private RoleEnum role;
        private String name;
        private String surname;
        private String patronymic;
        private AddressDB address;
        private LibraryDB library;
        private UserCardDB userCard;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withLogin(String val) {
            login = val;
            return this;
        }

        public Builder withPassword(String val) {
            password = val;
            return this;
        }

        public Builder withRole(RoleEnum val) {
            role = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withSurname(String val) {
            surname = val;
            return this;
        }

        public Builder withPatronymic(String val) {
            patronymic = val;
            return this;
        }

        public Builder withAddress(AddressDB val) {
            address = val;
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

        public UserDB build() {
            return new UserDB(this);
        }
    }
}
