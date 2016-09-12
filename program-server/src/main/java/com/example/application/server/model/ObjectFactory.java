package com.example.application.server.model;

import com.example.application.server.model.action.*;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public GetUserByIdResponse createGetUserByIdResponse() {
        return new GetUserByIdResponse();
    }

    public UserDTO createUser() {
        return new UserDTO();
    }

    public GetUsersRequest createGetUsersRequest() {
        return new GetUsersRequest();
    }

    public GetUserByUsernameRequest createGetUserByUsernameRequest() {
        return new GetUserByUsernameRequest();
    }

    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    public DeleteUserRequest createDeleteUserRequest() {
        return new DeleteUserRequest();
    }

    public GetUserByIdRequest createGetUserByIdRequest() {
        return new GetUserByIdRequest();
    }

    public GetUserByUsernameResponse createGetUserByUsernameResponse() {
        return new GetUserByUsernameResponse();
    }

    public SaveUserResponse createSaveUserResponse() {
        return new SaveUserResponse();
    }

    public SaveUserRequest createSaveUserRequest() {
        return new SaveUserRequest();
    }

    public UpdateUserRequest createUpdateUserRequest() {
        return new UpdateUserRequest();
    }

    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    public GetUsersResponse createGetUsersResponse() {
        return new GetUsersResponse();
    }

    public SaveLibraryRequest createSaveLibraryRequest() {
        return new SaveLibraryRequest();
    }

    public SaveLibraryResponse createSaveLibraryResponse() {
        return new SaveLibraryResponse();
    }

    public UpdateLibraryRequest createUpdateLibraryRequest() {
        return new UpdateLibraryRequest();
    }

    public UpdateLibraryResponse createUpdateLibraryResponse() {
        return new UpdateLibraryResponse();
    }

    public DeleteLibraryRequest createDeleteLibraryRequest() {
        return new DeleteLibraryRequest();
    }

    public DeleteLibraryResponse createDeleteLibraryResponse() {
        return new DeleteLibraryResponse();
    }

    public GetLibraryByIdRequest createGetLibraryByIdRequest() {
        return new GetLibraryByIdRequest();
    }

    public GetLibraryByIdResponse createGetLibraryByIdResponse() {
        return new GetLibraryByIdResponse();
    }

    public GetLibrariesRequest createGetLibrariesRequest() {
        return new GetLibrariesRequest();
    }

    public GetLibrariesResponse createGetLibrariesResponse() {
        return new GetLibrariesResponse();
    }

    public SaveBookRequest createSaveBookRequest() {
        return new SaveBookRequest();
    }

    public SaveBookResponse createSaveBookResponse() {
        return new SaveBookResponse();
    }

    public UpdateBookRequest createUpdateBookRequest() {
        return new UpdateBookRequest();
    }

    public UpdateBookResponse createUpdateBookResponse() {
        return new UpdateBookResponse();
    }

    public DeleteBookRequest createDeleteBookRequest() {
        return new DeleteBookRequest();
    }

    public DeleteBookResponse createDeleteBookResponse() {
        return new DeleteBookResponse();
    }

    public GetBookByIdRequest createGetBookByIdRequest() {
        return new GetBookByIdRequest();
    }

    public GetBookByIdResponse createGetBookByIdResponse() {
        return new GetBookByIdResponse();
    }

    public GetBooksRequest createGetBooksRequest() {
        return new GetBooksRequest();
    }

    public GetBooksResponse createGetBooksResponse() {
        return new GetBooksResponse();
    }

    public SearchUsersRequest createSearchUsersRequest() {
        return new SearchUsersRequest();
    }

    public SearchUsersResponse createSearchUsersResponse() {
        return new SearchUsersResponse();
    }

    public SearchBooksRequest createSearchBooksRequest() {
        return new SearchBooksRequest();
    }

    public SearchBooksResponse createSearchBooksResponse() {
        return new SearchBooksResponse();
    }

    public GetTrackingRequest createGetTrackingRequest() {
        return new GetTrackingRequest();
    }

    public GetTrackingResponse createGetTrackingResponse() {
        return new GetTrackingResponse();
    }

    public SaveTrackingRequest createSaveTrackingRequest() {
        return new SaveTrackingRequest();
    }

    public SaveTrackingResponse createSaveTrackingResponse() {
        return new SaveTrackingResponse();
    }

    public UpdateTrackingRequest createUpdateTrackingRequest() {
        return new UpdateTrackingRequest();
    }

    public UpdateTrackingResponse createUpdateTrackingResponse() {
        return new UpdateTrackingResponse();
    }
}
