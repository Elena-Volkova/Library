package com.example.application.server.endpoint;

import com.example.application.server.model.action.SearchBooksRequest;
import com.example.application.server.model.action.SearchBooksResponse;
import com.example.application.server.model.action.SearchUsersRequest;
import com.example.application.server.model.action.SearchUsersResponse;
import com.example.application.server.repository.BookDao;
import com.example.application.server.repository.LibraryDao;
import com.example.application.server.repository.UserDao;
import com.example.application.server.repository.model.BookDB;
import com.example.application.server.repository.model.LibraryDB;
import com.example.application.server.repository.model.UserDB;
import com.example.application.server.util.BookBuilderUtil;
import com.example.application.server.util.LibraryBuilderUtil;
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
public class SearchEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/application/server/model";

    private final UserDao userDao;

    private final BookDao bookDao;

    private final LibraryDao libraryDao;

    @Autowired
    public SearchEndpoint(UserDao userDao, BookDao bookDao, LibraryDao libraryDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
        this.libraryDao = libraryDao;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchUsersRequest")
    @ResponsePayload
    @Transactional
    public SearchUsersResponse searchUsersRequest(@RequestPayload SearchUsersRequest request) {
        SearchUsersResponse response = new SearchUsersResponse();
        List<UserDB> users = userDao.findUsersBySearchDTO(request.getSearch());
        response.setSearch(request.getSearch());
        response.getSearch().setUsers(users.stream()
                .map(UserBuilderUtil::convertUserDBToUser)
                .collect(Collectors.toList()));
        if (request.getSearch().getLibrary() != null) {
            LibraryDB libraryDB = libraryDao.findById(request.getSearch().getLibrary().getId());
            response.getSearch().setLibrary(LibraryBuilderUtil.convertLibraryDBToLibrary(libraryDB));
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchBooksRequest")
    @ResponsePayload
    @Transactional
    public SearchBooksResponse searchBooksRequest(@RequestPayload SearchBooksRequest request) {
        SearchBooksResponse response = new SearchBooksResponse();
        List<BookDB> books = bookDao.findBooksBySearchDTO(request.getSearch());
        response.setSearch(request.getSearch());
        response.getSearch().setBooks(books.stream()
                .map(BookBuilderUtil::convertBookDBToBook)
                .collect(Collectors.toList()));
        if (request.getSearch().getLibrary() != null) {
            LibraryDB libraryDB = libraryDao.findById(request.getSearch().getLibrary().getId());
            response.getSearch().setLibrary(LibraryBuilderUtil.convertLibraryDBToLibrary(libraryDB));
        }
        return response;
    }
}
