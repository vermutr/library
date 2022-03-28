package net.roma.librarydemo.controllers.dto;

import lombok.*;

import java.util.Set;


@Data
@RequiredArgsConstructor
public class AuthorDto extends AbstractDto {

    private String name;
    private Set<BookInAuthorDto> books;

}
