package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userCard", propOrder = {
        "id",
        "dateFrom",
        "dateTo",
        "returned",
        "user",
        "book"
})
public class UserCardDTO {

    private Long id;
    private Date dateFrom;
    private Date dateTo;
    private Boolean returned;
    private UserDTO user;
    private BookDTO book;

    public UserCardDTO() {
    }

    private UserCardDTO(Builder builder) {
        setId(builder.id);
        setDateFrom(builder.dateFrom);
        setDateTo(builder.dateTo);
        setReturned(builder.returned);
        setUser(builder.user);
        setBook(builder.book);
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

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public static final class Builder {
        private Long id;
        private Date dateFrom;
        private Date dateTo;
        private Boolean returned;
        private UserDTO user;
        private BookDTO book;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withDateFrom(Date val) {
            dateFrom = val;
            return this;
        }

        public Builder withDateTo(Date val) {
            dateTo = val;
            return this;
        }

        public Builder withReturned(Boolean val) {
            returned = val;
            return this;
        }

        public Builder withUser(UserDTO val) {
            user = val;
            return this;
        }

        public Builder withBook(BookDTO val) {
            book = val;
            return this;
        }

        public UserCardDTO build() {
            return new UserCardDTO(this);
        }
    }
}
