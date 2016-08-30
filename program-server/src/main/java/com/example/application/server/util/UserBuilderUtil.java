package com.example.application.server.util;

import com.example.application.server.model.UserDTO;
import com.example.application.server.repository.model.UserDB;
import org.springframework.stereotype.Component;

@Component
public class UserBuilderUtil {

    public static UserDB convertUserToUserDB(UserDTO user) {
        return UserDB.newBuilder()
                .withId(user.getId())
                .withLogin(user.getLogin())
                .withPassword(user.getPassword())
                .withRole(user.getRole())
                .withName(user.getName())
                .withSurname(user.getSurname())
                .withPatronymic(user.getPatronymic())
                .withAddress(user.getAddress() != null ? AddressBuilderUtil.convertAddressToAddressDB(user.getAddress()) : null)
                .withLibrary(user.getLibrary() != null ? LibraryBuilderUtil.convertLibraryToLibraryDB(user.getLibrary()) : null)
                .build();
    }

    public static UserDTO convertUserDBToUser(UserDB user) {
        if (user == null){
            return null;
        } else {
            return UserDTO.newBuilder()
                    .withId(user.getId())
                    .withLogin(user.getLogin())
                    .withPassword(user.getPassword())
                    .withRole(user.getRole())
                    .withName(user.getName())
                    .withSurname(user.getSurname())
                    .withPatronymic(user.getPatronymic())
                    .withAddress(user.getAddress() != null ? AddressBuilderUtil.convertAddressDBToAddress(user.getAddress()) : null)
                    .withLibrary(user.getLibrary() != null ? LibraryBuilderUtil.convertLibraryDBToLibrary(user.getLibrary()) : null)
                    .build();
        }
    }

}
