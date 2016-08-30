package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "roleEnum")
@XmlEnum
public enum RoleEnum {

    ADMIN,
    USER;

    public static RoleEnum fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
