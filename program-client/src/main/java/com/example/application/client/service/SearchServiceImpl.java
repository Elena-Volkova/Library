package com.example.application.client.service;

import com.example.application.client.endpoint.ServiceWSClient;
import com.example.application.client.service.model.BookSearchDTO;
import com.example.application.client.service.model.UserSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    private ServiceWSClient serviceWSClient;

    @Autowired
    public SearchServiceImpl(ServiceWSClient serviceWSClient) {
        this.serviceWSClient = serviceWSClient;
    }

    @Override
    public UserSearchDTO searchUsers(UserSearchDTO userSearch) {
        return serviceWSClient.searchUsers(userSearch).getSearch();
    }

    @Override
    public BookSearchDTO searchBooks(BookSearchDTO bookSearch) {
        return serviceWSClient.searchBooks(bookSearch).getSearch();
    }
}
