package com.example.application.server.model.action;

import com.example.application.server.model.UserDTO;

import javax.xml.bind.annotation.*;
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
