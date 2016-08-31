package com.example.application.server.endpoint;

import com.example.application.server.model.action.*;
import com.example.application.server.repository.UserDao;
import com.example.application.server.repository.model.UserDB;
import com.example.application.server.util.UserBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/application/server/model";

    private final UserDao userDao;

    @Autowired
    public UserEndpoint(UserDao userDao) {
        this.userDao = userDao;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveUserRequest")
    @ResponsePayload
    @Transactional
    public SaveUserResponse saveUserRequest(@RequestPayload SaveUserRequest request) {
        SaveUserResponse response = new SaveUserResponse();
        userDao.saveUser(
                UserBuilderUtil.convertUserToUserDB(request.getUser())
        );
        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    @Transactional
    public UpdateUserResponse updateUserRequest(@RequestPayload UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        userDao.updateUser(
                UserBuilderUtil.convertUserToUserDB(request.getUser())
        );
        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    @Transactional
    public DeleteUserResponse deleteUserRequest(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        userDao.deleteUser(
                request.getUserId()
        );
        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    @Transactional
    public GetUserByIdResponse getUserByIdRequest(@RequestPayload GetUserByIdRequest request) {
        GetUserByIdResponse response = new GetUserByIdResponse();
        UserDB user = userDao.findById(
                request.getUserId()
        );
        response.setUser(UserBuilderUtil.convertUserDBToUser(user));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByUsernameRequest")
    @ResponsePayload
    @Transactional
    public GetUserByUsernameResponse getUserByUsernameRequest(@RequestPayload GetUserByUsernameRequest request) {
        GetUserByUsernameResponse response = new GetUserByUsernameResponse();
        UserDB user = userDao.findByUsername(
                request.getUsername()
        );
        response.setUser(UserBuilderUtil.convertUserDBToUser(user));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsersRequest")
    @ResponsePayload
    @Transactional
    public GetUsersResponse getUsersRequest(@RequestPayload GetUsersRequest request) {
        GetUsersResponse response = new GetUsersResponse();
        List<UserDB> users = userDao.findAllUsers();
        response.setUsers(
                users.stream()
                        .map(UserBuilderUtil::convertUserDBToUser)
                        .collect(Collectors.toList())
        );
        return response;
    }
}
