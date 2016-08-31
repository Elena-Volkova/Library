package com.example.application.server.util;

import com.example.application.server.model.AddressDTO;
import com.example.application.server.model.LibraryDTO;
import com.example.application.server.repository.model.AddressDB;
import com.example.application.server.repository.model.LibraryDB;
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

    public static void mergeAddressWithAddressDB(AddressDB addressDB, AddressDTO addressDTO) {
        addressDB.setCountry(addressDTO.getCountry());
        addressDB.setCity(addressDTO.getCity());
        addressDB.setStreet(addressDTO.getStreet());
        addressDB.setPhone(addressDTO.getPhone());
    }
}
