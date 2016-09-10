package com.example.application.server.model.action;

import com.example.application.server.model.BookDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "book"
})
@XmlRootElement(name = "getBookByIdResponse")
public class GetBookByIdResponse {

    @XmlElement(required = true)
    protected BookDTO book;

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }
}
