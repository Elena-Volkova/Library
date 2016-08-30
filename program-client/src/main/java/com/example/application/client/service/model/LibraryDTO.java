package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "library", propOrder = {
        "id",
        "name",
        "address"
})
public class LibraryDTO {

    private Long id;
    private String name;
    private AddressDTO address;

    public LibraryDTO() {
    }

    private LibraryDTO(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setAddress(builder.address);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private AddressDTO address;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withAddress(AddressDTO val) {
            address = val;
            return this;
        }

        public LibraryDTO build() {
            return new LibraryDTO(this);
        }
    }
}
