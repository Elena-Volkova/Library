package com.example.application.server.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user_card")
public class UserCardDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "returned")
    private Boolean returned;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserDB user;

    @OneToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private BookDB book;

    public UserCardDB() {
    }

    private UserCardDB(Builder builder) {
        id = builder.id;
        dateFrom = builder.dateFrom;
        dateTo = builder.dateTo;
        returned = builder.returned;
        user = builder.user;
        book = builder.book;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public Boolean getReturned() {
        return returned;
    }

    public UserDB getUser() {
        return user;
    }

    public BookDB getBook() {
        return book;
    }

    public static final class Builder {
        private Long id;
        private Date dateFrom;
        private Date dateTo;
        private Boolean returned;
        private UserDB user;
        private BookDB book;

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

        public Builder withUser(UserDB val) {
            user = val;
            return this;
        }

        public Builder withBook(BookDB val) {
            book = val;
            return this;
        }

        public UserCardDB build() {
            return new UserCardDB(this);
        }
    }
}
