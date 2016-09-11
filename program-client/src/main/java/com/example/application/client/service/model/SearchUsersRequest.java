package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "search"
})@XmlRootElement(name = "searchUsersRequest")
public class SearchUsersRequest {

    @XmlElement(required = true)
    protected UserSearchDTO search;

    public UserSearchDTO getSearch() {
        return search;
    }

    public void setSearch(UserSearchDTO search) {
        this.search = search;
    }
}
