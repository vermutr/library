package net.roma.librarydemo.controllers.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookInAuthorDto {

    private String name;
    private String isbn;
    private String bookAnnotation;
    private String genreOfBook;
    private String numberOfPages;

}
