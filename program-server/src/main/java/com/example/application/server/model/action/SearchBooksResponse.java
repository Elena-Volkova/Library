package com.example.application.server.model.action;

import com.example.application.server.model.BookSearchDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "search"
})
@XmlRootElement(name = "searchBooksResponse")
public class SearchBooksResponse {

    @XmlElement(required = true)
    protected BookSearchDTO search;

    public BookSearchDTO getSearch() {
        if (search.getBooks() == null) {
            search.setBooks(new ArrayList<>());
        }
        return search;
    }

    public void setSearch(BookSearchDTO search) {
        this.search = search;
    }
}
