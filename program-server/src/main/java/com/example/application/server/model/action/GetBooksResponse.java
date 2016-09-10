package com.example.application.server.model.action;

import com.example.application.server.model.BookDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "books"
})
@XmlRootElement(name = "getBooksResponse")
public class GetBooksResponse {

    @XmlElement(required = true)
    protected List<BookDTO> books;

    public List<BookDTO> getBooks() {
        if (books == null) {
            books = new ArrayList<>();
        }
        return this.books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
