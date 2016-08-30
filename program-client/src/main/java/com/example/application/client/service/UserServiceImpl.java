package com.example.application.client.service;

import com.example.application.client.endpoint.ServiceWSClient;
import com.example.application.client.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private ServiceWSClient serviceWSClient;

    @Autowired
    public UserServiceImpl(ServiceWSClient serviceWSClient) {
        this.serviceWSClient = serviceWSClient;
    }

    @Override
    public void add(UserDTO user) {
        serviceWSClient.saveUser(user);
    }

    @Override
    public void update(UserDTO user) {
        serviceWSClient.updateUser(user);
    }

    @Override
    public void delete(Long userId) {
        serviceWSClient.deleteUser(userId);
    }

    @Override
    public UserDTO getUser(Long userId) {
        return serviceWSClient.getUserById(userId).getUser();
    }

    @Override
    public List<UserDTO> getUsers() {
        return serviceWSClient.getUsers().getUsers();
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return serviceWSClient.getUserByUsername(username).getUser();
    }
}
