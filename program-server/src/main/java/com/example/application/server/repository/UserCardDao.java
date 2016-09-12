package com.example.application.server.repository;

import com.example.application.server.repository.model.UserCardDB;

import java.util.List;

public interface UserCardDao {

    List<UserCardDB> findAllUserCards(Long userId);

    void saveUserCard(UserCardDB userCard);

    void updateUserCard(UserCardDB userCard);

    UserCardDB findUserCardByUserAndBook(Long userId, Long bookId);
}
