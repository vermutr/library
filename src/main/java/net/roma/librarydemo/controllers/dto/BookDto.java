package net.roma.librarydemo.controllers.dto;

import lombok.*;

import java.util.Set;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BookDto extends AbstractDto {

    private String name;
    private String isbn;
    private String bookAnnotation;
    private String genreOfBook;
    private String numberOfPages;
    private Set<AuthorInBookDto> authors;

}
