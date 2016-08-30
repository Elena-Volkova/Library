package com.example.application.server.util;

import com.example.application.server.model.UserCardDTO;
import com.example.application.server.repository.model.UserCardDB;
import org.springframework.stereotype.Component;

@Component
public class UserCardBuilderUtil {

    public static UserCardDB convertUserCardToUserCardDB(UserCardDTO userCard) {
        return UserCardDB.newBuilder()
                .withId(userCard.getId())
                .withDateFrom(userCard.getDateFrom())
                .withDateTo(userCard.getDateTo())
                .withReturned(userCard.getReturned())
                .withUser(userCard.getUser() != null ? UserBuilderUtil.convertUserToUserDB(userCard.getUser()) : null)
                .withBook(userCard.getBook() != null ? BookBuilderUtil.convertBookToBookDB(userCard.getBook()) : null)
                .build();
    }

    public static UserCardDTO convertUserCardDBToUserCard(UserCardDB userCard) {
        if (userCard == null){
            return null;
        } else {
            return UserCardDTO.newBuilder()
                    .withId(userCard.getId())
                    .withDateFrom(userCard.getDateFrom())
                    .withDateTo(userCard.getDateTo())
                    .withReturned(userCard.getReturned())
                    .withUser(userCard.getUser() != null ? UserBuilderUtil.convertUserDBToUser(userCard.getUser()) : null)
                    .withBook(userCard.getBook() != null ? BookBuilderUtil.convertBookDBToBook(userCard.getBook()) : null)
                    .build();
        }
    }

}
