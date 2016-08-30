package com.example.application.client.service;

import com.example.application.client.endpoint.ServiceWSClient;
import com.example.application.client.service.model.LibraryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    private ServiceWSClient serviceWSClient;

    @Autowired
    public LibraryServiceImpl(ServiceWSClient serviceWSClient) {
        this.serviceWSClient = serviceWSClient;
    }

    @Override
    public void add(LibraryDTO library) {
        serviceWSClient.saveLibrary(library);
    }

    @Override
    public void update(LibraryDTO library) {
        serviceWSClient.updateLibrary(library);
    }

    @Override
    public void delete(Long libraryId) {
        serviceWSClient.deleteLibrary(libraryId);
    }

    @Override
    public LibraryDTO getLibrary(Long libraryId) {
        return serviceWSClient.getLibraryById(libraryId).getLibrary();
    }

    @Override
    public List<LibraryDTO> getLibraries() {
        return serviceWSClient.getLibraries().getLibraries();
    }
}
