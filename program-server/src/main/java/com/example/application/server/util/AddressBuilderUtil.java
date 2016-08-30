package com.example.application.server.util;

import com.example.application.server.model.AddressDTO;
import com.example.application.server.repository.model.AddressDB;
import org.springframework.stereotype.Component;

@Component
public class AddressBuilderUtil {

    public static AddressDB convertAddressToAddressDB(AddressDTO address) {
        return AddressDB.newBuilder()
                .withId(address.getId())
                .withCountry(address.getCountry())
                .withCity(address.getCity())
                .withStreet(address.getStreet())
                .withPhone(address.getPhone())
                .build();
    }

    public static AddressDTO convertAddressDBToAddress(AddressDB address) {
        if (address == null){
            return null;
        } else {
            return AddressDTO.newBuilder()
                    .withId(address.getId())
                    .withCountry(address.getCountry())
                    .withCity(address.getCity())
                    .withStreet(address.getStreet())
                    .withPhone(address.getPhone())
                    .build();
        }
    }

}
