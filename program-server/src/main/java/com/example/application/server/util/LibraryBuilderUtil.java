package com.example.application.server.util;

import com.example.application.server.model.LibraryDTO;
import com.example.application.server.repository.model.LibraryDB;
import org.springframework.stereotype.Component;

@Component
public class LibraryBuilderUtil {

    public static LibraryDB convertLibraryToLibraryDB(LibraryDTO library) {
        return LibraryDB.newBuilder()
                .withId(library.getId())
                .withName(library.getName())
                .withAddress(library.getAddress() != null ? AddressBuilderUtil.convertAddressToAddressDB(library.getAddress()) : null)
                .build();
    }

    public static LibraryDTO convertLibraryDBToLibrary(LibraryDB library) {
        if (library == null){
            return null;
        } else {
            return LibraryDTO.newBuilder()
                    .withId(library.getId())
                    .withId(library.getId())
                    .withName(library.getName())
                    .withAddress(library.getAddress() != null ? AddressBuilderUtil.convertAddressDBToAddress(library.getAddress()) : null)
                    .build();
        }
    }
}
