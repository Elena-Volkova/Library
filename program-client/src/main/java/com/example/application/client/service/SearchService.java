package com.example.application.client.service;

import com.example.application.client.service.model.BookSearchDTO;
import com.example.application.client.service.model.UserSearchDTO;

public interface SearchService {

    UserSearchDTO searchUsers(UserSearchDTO userSearch);

    BookSearchDTO searchBooks(BookSearchDTO bookSearch);
}
