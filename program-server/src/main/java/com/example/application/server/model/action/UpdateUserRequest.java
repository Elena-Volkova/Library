package com.example.application.server.model.action;

import com.example.application.server.model.UserDTO;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "user"
})
@XmlRootElement(name = "updateUserRequest")
public class UpdateUserRequest {

    @XmlElement(required = true)
    protected UserDTO user;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO value) {
        this.user = value;
    }

}
