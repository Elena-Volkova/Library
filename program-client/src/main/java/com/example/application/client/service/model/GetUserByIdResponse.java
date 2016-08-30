package com.example.application.client.service.model;

import com.example.application.client.service.model.UserDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "user"
})
@XmlRootElement(name = "getUserByIdResponse")
public class GetUserByIdResponse {

    @XmlElement(required = true)
    protected UserDTO user;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO value) {
        this.user = value;
    }

}
