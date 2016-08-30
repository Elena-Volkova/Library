package com.example.application.server.repository;

import com.example.application.server.repository.model.LibraryDB;

import java.util.List;

public interface LibraryDao {

    List<LibraryDB> findAllLibraries();

    LibraryDB findById(Long libraryId);

    void saveLibrary(LibraryDB library);

    void deleteLibrary(Long libraryId);

    void updateLibrary(LibraryDB library);

}
