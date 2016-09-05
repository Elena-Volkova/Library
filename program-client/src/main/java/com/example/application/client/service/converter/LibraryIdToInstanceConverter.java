package com.example.application.client.service.converter;

import com.example.application.client.service.model.LibraryDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LibraryIdToInstanceConverter implements Converter<String, LibraryDTO> {

    @Override
    public LibraryDTO convert(String libraryId) {
        return LibraryDTO.newBuilder()
                .withId(Long.valueOf(libraryId))
                .build();
    }
}
