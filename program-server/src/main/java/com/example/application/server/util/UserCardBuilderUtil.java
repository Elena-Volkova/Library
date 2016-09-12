package com.example.application.server.util;

import com.example.application.server.model.UserCardDTO;
import com.example.application.server.repository.model.UserCardDB;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserCardBuilderUtil {

    public static UserCardDB convertUserCardToUserCardDB() {
        LocalDateTime curDate = LocalDateTime.now();
        Date dateFrom = Date.from(curDate.atZone(ZoneId.systemDefault()).toInstant());
        Date dateTo = Date.from(curDate.plusDays(30).atZone(ZoneId.systemDefault()).toInstant());
        return UserCardDB.newBuilder()
                .withDateFrom(dateFrom)
                .withDateTo(dateTo)
                .withReturned(Boolean.FALSE)
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
                    .withLibrary(userCard.getBook() != null ? LibraryBuilderUtil.convertLibraryDBToLibrary(userCard.getBook().getLibrary()) : null)
                    .build();
        }
    }

    public static List<UserCardDTO> convertUserCardsDBToUserCards(List<UserCardDB> userCards) {
        return userCards.stream().map(UserCardBuilderUtil::convertUserCardDBToUserCard).collect(Collectors.toList());
    }
}
