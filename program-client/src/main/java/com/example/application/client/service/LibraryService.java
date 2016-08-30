package com.example.application.client.service;

import com.example.application.client.service.model.LibraryDTO;

import java.util.List;

public interface LibraryService {

    void add(LibraryDTO library);

    void update(LibraryDTO library);

    void delete(Long libraryId);

    LibraryDTO getLibrary(Long libraryId);

    List<LibraryDTO> getLibraries();
}
