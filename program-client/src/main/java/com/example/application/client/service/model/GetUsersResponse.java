package com.example.application.client.service.model;

import com.example.application.client.service.model.UserDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "users"
})
@XmlRootElement(name = "getUsersResponse")
public class GetUsersResponse {

    @XmlElement(required = true)
    protected List<UserDTO> users;

    public List<UserDTO> getUsers() {
        if (users == null) {
            users = new ArrayList<UserDTO>();
        }
        return this.users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
