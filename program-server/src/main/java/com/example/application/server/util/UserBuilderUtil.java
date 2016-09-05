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
                    .withLibraries(user.getLibraries() != null ? LibraryBuilderUtil.convertLibrariesDBToLibraries(user.getLibraries()) : null)
                    .build();
        }
    }

    public static void mergeUserWithUserDB(UserDB userDB, UserDTO userDTO) {
        userDB.setLogin(userDTO.getLogin());
        userDB.setPassword(userDTO.getPassword() != null ? userDTO.getPassword() : userDB.getPassword());
        userDB.setRole(userDTO.getRole());
        userDB.setName(userDTO.getName());
        userDB.setSurname(userDTO.getSurname());
        userDB.setPatronymic(userDTO.getPatronymic());
        AddressBuilderUtil.mergeAddressWithAddressDB(userDB.getAddress(), userDTO.getAddress());
    }
}
