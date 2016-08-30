package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "libraries"
})
@XmlRootElement(name = "getLibrariesResponse")
public class GetLibrariesResponse {

    @XmlElement(required = true)
    protected List<LibraryDTO> libraries;

    public List<LibraryDTO> getLibraries() {
        if (libraries == null) {
            libraries = new ArrayList<>();
        }
        return this.libraries;
    }

    public void setUsers(List<LibraryDTO> libraries) {
        this.libraries = libraries;
    }
}
