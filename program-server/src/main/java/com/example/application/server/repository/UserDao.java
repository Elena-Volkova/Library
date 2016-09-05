package com.example.application.server.repository;

import com.example.application.server.model.RoleEnum;
import com.example.application.server.repository.model.UserDB;

import java.util.List;

public interface UserDao {

    List<UserDB> findUsersByRole(List<RoleEnum> roles);

    UserDB findById(Long userId);

    UserDB findByUsername(String username);

    void saveUser(UserDB user);

    void deleteUser(Long userId);

    void updateUser(UserDB user);

}
