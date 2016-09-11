package com.example.application.server.model.action;

import com.example.application.server.model.UserSearchDTO;

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
@XmlRootElement(name = "searchUsersResponse")
public class SearchUsersResponse {

    @XmlElement(required = true)
    protected UserSearchDTO search;

    public UserSearchDTO getSearch() {
        if (search.getUsers() == null) {
            search.setUsers(new ArrayList<>());
        }
        return search;
    }

    public void setSearch(UserSearchDTO search) {
        this.search = search;
    }
}
