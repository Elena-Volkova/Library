package com.example.application.server.model.action;

import com.example.application.server.model.BookSearchDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "search"
})@XmlRootElement(name = "searchBooksRequest")
public class SearchBooksRequest {

    @XmlElement(required = true)
    protected BookSearchDTO search;

    public BookSearchDTO getSearch() {
        return search;
    }

    public void setSearch(BookSearchDTO search) {
        this.search = search;
    }
}
