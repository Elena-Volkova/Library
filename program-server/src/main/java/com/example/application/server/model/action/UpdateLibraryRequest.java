package com.example.application.server.model.action;

import com.example.application.server.model.LibraryDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "library"
})
@XmlRootElement(name = "updateLibraryRequest")
public class UpdateLibraryRequest {

    @XmlElement(required = true)
    protected LibraryDTO library;

    public LibraryDTO getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDTO library) {
        this.library = library;
    }
}
