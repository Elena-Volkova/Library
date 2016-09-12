package com.example.application.client.endpoint;

import com.example.application.client.service.model.*;
import org.apache.log4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class ServiceWSClient extends WebServiceGatewaySupport {

    private static final Logger LOGGER = Logger.getLogger(ServiceWSClient.class);
    private static final String WEBSERVICE_URL = "http://localhost:8080/server/ws";

    public GetUserByIdResponse getUserById(Long userId) {
        GetUserByIdRequest request = new GetUserByIdRequest();
        request.setUserId(userId);

        LOGGER.info("Requesting user for id = " + userId);

        return (GetUserByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/GetUserByIdResponse"));
    }

    public GetUserByUsernameResponse getUserByUsername(String username) {
        GetUserByUsernameRequest request = new GetUserByUsernameRequest();
        request.setUsername(username);

        LOGGER.info("Requesting user for username = " + username);

        return (GetUserByUsernameResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/GetUserByUsernameResponse"));
    }

    public GetUsersResponse getUsers(List<RoleEnum> roles) {
        GetUsersRequest request = new GetUsersRequest();
        request.setRoles(roles);

        LOGGER.info("Requesting all users");

        return (GetUsersResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/GetUsersResponse"));
    }

    public SaveUserResponse saveUser(UserDTO user) {
        SaveUserRequest request = new SaveUserRequest();
        request.setUser(user);

        LOGGER.info("Requesting save user");

        return (SaveUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/SaveUserResponse"));
    }

    public UpdateUserResponse updateUser(UserDTO user) {
        UpdateUserRequest request = new UpdateUserRequest();
        request.setUser(user);

        LOGGER.info("Requesting update user");

        return (UpdateUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/UpdateUserResponse"));
    }

    public DeleteUserResponse deleteUser(Long userId) {
        DeleteUserRequest request = new DeleteUserRequest();
        request.setUserId(userId);

        LOGGER.info("Requesting delete user for id = " + userId);

        return (DeleteUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/DeleteUserResponse"));
    }

    public SaveLibraryResponse saveLibrary(LibraryDTO library) {
        SaveLibraryRequest request = new SaveLibraryRequest();
        request.setLibrary(library);

        LOGGER.info("Requesting save library");

        return (SaveLibraryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/SaveLibraryResponse"));
    }

    public UpdateLibraryResponse updateLibrary(LibraryDTO library) {
        UpdateLibraryRequest request = new UpdateLibraryRequest();
        request.setLibrary(library);

        LOGGER.info("Requesting update library");

        return (UpdateLibraryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/UpdateLibraryResponse"));
    }

    public DeleteLibraryResponse deleteLibrary(Long libraryId) {
        DeleteLibraryRequest request = new DeleteLibraryRequest();
        request.setLibraryId(libraryId);

        LOGGER.info("Requesting delete library for id = " + libraryId);

        return (DeleteLibraryResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/DeleteLibraryResponse"));
    }

    public GetLibraryByIdResponse getLibraryById(Long libraryId) {
        GetLibraryByIdRequest request = new GetLibraryByIdRequest();
        request.setLibraryId(libraryId);

        LOGGER.info("Requesting library for id = " + libraryId);

        return (GetLibraryByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/GetLibraryByIdResponse"));
    }

    public GetLibrariesResponse getLibraries() {
        GetLibrariesRequest request = new GetLibrariesRequest();

        LOGGER.info("Requesting all libraries");

        return (GetLibrariesResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/GetLibrariesResponse"));
    }

    public SaveBookResponse saveBook(BookDTO book) {
        SaveBookRequest request = new SaveBookRequest();
        request.setBook(book);

        LOGGER.info("Requesting save book");

        return (SaveBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/SaveBookResponse"));
    }

    public UpdateBookResponse updateBook(BookDTO book) {
        UpdateBookRequest request = new UpdateBookRequest();
        request.setBook(book);

        LOGGER.info("Requesting update book");

        return (UpdateBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/UpdateBookResponse"));
    }

    public DeleteBookResponse deleteBook(Long bookId) {
        DeleteBookRequest request = new DeleteBookRequest();
        request.setBookId(bookId);

        LOGGER.info("Requesting delete book for id = " + bookId);

        return (DeleteBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/DeleteBookResponse"));
    }

    public GetBookByIdResponse getBookById(Long bookId) {
        GetBookByIdRequest request = new GetBookByIdRequest();
        request.setBookId(bookId);

        LOGGER.info("Requesting book for id = " + bookId);

        return (GetBookByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/GetBookByIdResponse"));
    }

    public GetBooksResponse getBooks() {
        GetBooksRequest request = new GetBooksRequest();

        LOGGER.info("Requesting all books");

        return (GetBooksResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/GetBooksResponse"));
    }

    public SearchUsersResponse searchUsers(UserSearchDTO userSearch) {
        SearchUsersRequest request = new SearchUsersRequest();
        request.setSearch(userSearch);

        LOGGER.info("Requesting searchBooks users");

        return (SearchUsersResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/SearchUsersResponse"));
    }

    public SearchBooksResponse searchBooks(BookSearchDTO bookSearch) {
        SearchBooksRequest request = new SearchBooksRequest();
        request.setSearch(bookSearch);

        LOGGER.info("Requesting searchBooks books");

        return (SearchBooksResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/SearchBooksResponse"));
    }

    public GetTrackingResponse getTracking(TrackingDTO tracking) {
        GetTrackingRequest request = new GetTrackingRequest();
        request.setTracking(tracking);

        LOGGER.info("Requesting searchBooks books");

        return (GetTrackingResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/GetTrackingResponse"));
    }

    public UpdateTrackingResponse updateTracking(Long bookId, Long userId) {
        UpdateTrackingRequest request = new UpdateTrackingRequest();
        request.setBookId(bookId);
        request.setUserId(userId);

        LOGGER.info("Requesting update tracking");

        return (UpdateTrackingResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/UpdateTrackingResponse"));
    }

    public SaveTrackingResponse addTracking(Long bookId, Long userId) {
        SaveTrackingRequest request = new SaveTrackingRequest();
        request.setBookId(bookId);
        request.setUserId(userId);

        LOGGER.info("Requesting update tracking");

        return (SaveTrackingResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        WEBSERVICE_URL,
                        request,
                        new SoapActionCallback(WEBSERVICE_URL + "/SaveTrackingResponse"));
    }
}
