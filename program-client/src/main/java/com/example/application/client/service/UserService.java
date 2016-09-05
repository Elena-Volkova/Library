package com.example.application.client.service;

import com.example.application.client.service.model.RoleEnum;
import com.example.application.client.service.model.UserDTO;

import java.util.List;

public interface UserService {

    void add(UserDTO user);

    void update(UserDTO user);

    void delete(Long userId);

    UserDTO getUser(Long userId);

    List<UserDTO> getUsers(List<RoleEnum> roles);

    UserDTO getUserByUsername(String username);
}
