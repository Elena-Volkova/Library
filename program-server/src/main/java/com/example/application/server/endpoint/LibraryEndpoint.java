package com.example.application.server.endpoint;

import com.example.application.server.model.action.DeleteLibraryRequest;
import com.example.application.server.model.action.DeleteLibraryResponse;
import com.example.application.server.model.action.GetLibrariesRequest;
import com.example.application.server.model.action.GetLibrariesResponse;
import com.example.application.server.model.action.GetLibraryByIdRequest;
import com.example.application.server.model.action.GetLibraryByIdResponse;
import com.example.application.server.model.action.SaveLibraryRequest;
import com.example.application.server.model.action.SaveLibraryResponse;
import com.example.application.server.model.action.UpdateLibraryRequest;
import com.example.application.server.model.action.UpdateLibraryResponse;
import com.example.application.server.repository.LibraryDao;
import com.example.application.server.repository.model.LibraryDB;
import com.example.application.server.util.LibraryBuilderUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class LibraryEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/application/server/model";

    @Autowired
    private LibraryDao libraryDao;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveLibraryRequest")
    @ResponsePayload
    @Transactional
    public SaveLibraryResponse saveLibraryRequest(@RequestPayload SaveLibraryRequest request) {
        SaveLibraryResponse response = new SaveLibraryResponse();
        libraryDao.saveLibrary(
                LibraryBuilderUtil.convertLibraryToLibraryDB(request.getLibrary())
        );
        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateLibraryRequest")
    @ResponsePayload
    @Transactional
    public UpdateLibraryResponse updateLibraryRequest(@RequestPayload UpdateLibraryRequest request) {
        UpdateLibraryResponse response = new UpdateLibraryResponse();
        libraryDao.updateLibrary(
                LibraryBuilderUtil.convertLibraryToLibraryDB(request.getLibrary())
        );
        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteLibraryRequest")
    @ResponsePayload
    @Transactional
    public DeleteLibraryResponse deleteLibraryRequest(@RequestPayload DeleteLibraryRequest request) {
        DeleteLibraryResponse response = new DeleteLibraryResponse();
        libraryDao.deleteLibrary(
                request.getLibraryId()
        );
        response.setResult(Boolean.TRUE);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLibraryByIdRequest")
    @ResponsePayload
    @Transactional
    public GetLibraryByIdResponse getLibraryByIdRequest(@RequestPayload GetLibraryByIdRequest request) {
        GetLibraryByIdResponse response = new GetLibraryByIdResponse();
        LibraryDB library = libraryDao.findById(
                request.getLibraryId()
        );
        response.setLibrary(LibraryBuilderUtil.convertLibraryDBToLibrary(library));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLibrariesRequest")
    @ResponsePayload
    @Transactional
    public GetLibrariesResponse getLibrariesRequest(@RequestPayload GetLibrariesRequest request) {
        GetLibrariesResponse response = new GetLibrariesResponse();
        List<LibraryDB> libraries = libraryDao.findAllLibraries();
        response.setLibraries(
                libraries.stream()
                        .map(LibraryBuilderUtil::convertLibraryDBToLibrary)
                        .collect(Collectors.toList())
        );
        return response;
    }
}
