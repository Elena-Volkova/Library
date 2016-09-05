package com.example.application.server.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
        "id",
        "login",
        "password",
        "role",
        "name",
        "surname",
        "patronymic",
        "address",
        "libraries"
})
public class UserDTO {

    private Long id;
    private String login;
    private String password;
    private RoleEnum role;
    private String name;
    private String surname;
    private String patronymic;
    private AddressDTO address;
    private List<LibraryDTO> libraries;

    public UserDTO() {
    }

    private UserDTO(Builder builder) {
        setId(builder.id);
        setLogin(builder.login);
        setPassword(builder.password);
        setRole(builder.role);
        setName(builder.name);
        setSurname(builder.surname);
        setPatronymic(builder.patronymic);
        setAddress(builder.address);
        setLibraries(builder.libraries);
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<LibraryDTO> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<LibraryDTO> libraries) {
        this.libraries = libraries;
    }

    public static final class Builder {
        private Long id;
        private String login;
        private String password;
        private RoleEnum role;
        private String name;
        private String surname;
        private String patronymic;
        private AddressDTO address;
        private List<LibraryDTO> libraries;

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

        public Builder withAddress(AddressDTO val) {
            address = val;
            return this;
        }

        public Builder withLibraries(List<LibraryDTO> val) {
            libraries = val;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
