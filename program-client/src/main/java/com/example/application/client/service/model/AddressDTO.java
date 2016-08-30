package com.example.application.client.service.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {
        "id",
        "country",
        "city",
        "street",
        "phone"
})
public class AddressDTO {

    private Long id;
    private String country;
    private String city;
    private String street;
    private String phone;

    public AddressDTO() {
    }

    private AddressDTO(Builder builder) {
        setId(builder.id);
        setCountry(builder.country);
        setCity(builder.city);
        setStreet(builder.street);
        setPhone(builder.phone);
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static final class Builder {
        private Long id;
        private String country;
        private String city;
        private String street;
        private String phone;

        private Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withCountry(String val) {
            country = val;
            return this;
        }

        public Builder withCity(String val) {
            city = val;
            return this;
        }

        public Builder withStreet(String val) {
            street = val;
            return this;
        }

        public Builder withPhone(String val) {
            phone = val;
            return this;
        }

        public AddressDTO build() {
            return new AddressDTO(this);
        }
    }
}
