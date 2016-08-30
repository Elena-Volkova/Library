package com.example.application.server.model.action;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "username"
})
@XmlRootElement(name = "getUserByUsernameRequest")
public class GetUserByUsernameRequest {

    @XmlElement(required = true)
    protected String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

}
