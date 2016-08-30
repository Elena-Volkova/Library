package com.example.application.client.service.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "ServicesPort", targetNamespace = "http://example.com/application/server/model")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public interface ServicesPort {

    @WebMethod
    @WebResult(name = "getUserByIdResponse", targetNamespace = "http://example.com/application/server/model", partName = "getUserByIdResponse")
    public GetUserByIdResponse getUserById(
            @WebParam(name = "getUserByIdRequest", targetNamespace = "http://example.com/application/server/model", partName = "getUserByIdRequest")
            GetUserByIdRequest getUserByIdRequest);

    @WebMethod
    @WebResult(name = "getUsersResponse", targetNamespace = "http://example.com/application/server/model", partName = "getUsersResponse")
    public GetUsersResponse getUsers(
            @WebParam(name = "getUsersRequest", targetNamespace = "http://example.com/application/server/model", partName = "getUsersRequest")
            GetUsersRequest getUsersRequest);

    @WebMethod
    @WebResult(name = "getUserByUsernameResponse", targetNamespace = "http://example.com/application/server/model", partName = "getUserByUsernameResponse")
    public GetUserByUsernameResponse getUserByUsername(
            @WebParam(name = "getUserByUsernameRequest", targetNamespace = "http://example.com/application/server/model", partName = "getUserByUsernameRequest")
            GetUserByUsernameRequest getUserByUsernameRequest);

    @WebMethod
    @WebResult(name = "deleteUserResponse", targetNamespace = "http://example.com/application/server/model", partName = "deleteUserResponse")
    public DeleteUserResponse deleteUser(
            @WebParam(name = "deleteUserRequest", targetNamespace = "http://example.com/application/server/model", partName = "deleteUserRequest")
            DeleteUserRequest deleteUserRequest);

    @WebMethod
    @WebResult(name = "saveUserResponse", targetNamespace = "http://example.com/application/server/model", partName = "saveUserResponse")
    public SaveUserResponse saveUser(
            @WebParam(name = "saveUserRequest", targetNamespace = "http://example.com/application/server/model", partName = "saveUserRequest")
            SaveUserRequest saveUserRequest);

    @WebMethod
    @WebResult(name = "updateUserResponse", targetNamespace = "http://example.com/application/server/model", partName = "updateUserResponse")
    public UpdateUserResponse updateUser(
            @WebParam(name = "updateUserRequest", targetNamespace = "http://example.com/application/server/model", partName = "updateUserRequest")
                    UpdateUserRequest updateUserRequest);

    @WebMethod
    @WebResult(name = "saveLibraryResponse", targetNamespace = "http://example.com/application/server/model", partName = "saveLibraryResponse")
    public SaveLibraryResponse saveLibrary(
            @WebParam(name = "saveLibraryRequest", targetNamespace = "http://example.com/application/server/model", partName = "saveLibraryRequest")
                    SaveLibraryRequest saveLibraryRequest);

    @WebMethod
    @WebResult(name = "updateLibraryResponse", targetNamespace = "http://example.com/application/server/model", partName = "updateLibraryResponse")
    public UpdateLibraryResponse updateLibrary(
            @WebParam(name = "updateLibraryRequest", targetNamespace = "http://example.com/application/server/model", partName = "updateLibraryRequest")
                    UpdateLibraryRequest updateLibraryRequest);

    @WebMethod
    @WebResult(name = "deleteLibraryResponse", targetNamespace = "http://example.com/application/server/model", partName = "deleteLibraryResponse")
    public DeleteLibraryResponse deleteLibrary(
            @WebParam(name = "deleteLibraryRequest", targetNamespace = "http://example.com/application/server/model", partName = "deleteLibraryRequest")
                    DeleteLibraryRequest deleteLibraryRequest);

    @WebMethod
    @WebResult(name = "getLibraryByIdResponse", targetNamespace = "http://example.com/application/server/model", partName = "getLibraryByIdResponse")
    public GetLibraryByIdResponse getLibraryById(
            @WebParam(name = "getLibraryByIdRequest", targetNamespace = "http://example.com/application/server/model", partName = "getLibraryByIdRequest")
                    GetLibraryByIdRequest getLibraryByIdRequest);

    @WebMethod
    @WebResult(name = "getLibrariesResponse", targetNamespace = "http://example.com/application/server/model", partName = "getLibrariesResponse")
    public GetLibrariesResponse getLibraries(
            @WebParam(name = "getLibrariesRequest", targetNamespace = "http://example.com/application/server/model", partName = "getLibrariesRequest")
                    GetLibrariesRequest getLibrariesRequest);
}
