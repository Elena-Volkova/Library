package com.example.application.server.repository;

import com.example.application.server.repository.model.UserDB;

import java.util.List;

public interface UserDao {

    List<UserDB> findAllUsers();

    UserDB findById(Long userId);

    UserDB findByUsername(String username);

    void saveUser(UserDB user);

    void deleteUser(Long userId);

    void updateUser(UserDB user);

}
