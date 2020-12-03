package net.roma.librarydemo.controllers;

import lombok.RequiredArgsConstructor;
import net.roma.librarydemo.configutaion.DetailsConverter;
import net.roma.librarydemo.controllers.dto.AuthorDto;
import net.roma.librarydemo.model.Author;
import net.roma.librarydemo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/api/author/")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
@RequiredArgsConstructor
public class AuthorRestController {

    private final AuthorService authorService;
    private final DetailsConverter converter;

    @GetMapping(value = "{id}")
    public AuthorDto getAuthor(@PathVariable("id") @NotNull final Long authorId) {
        return converter.convert(this.authorService.getById(authorId), AuthorDto.class);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto saveAuthor(@RequestBody @NotNull @Valid final AuthorDto authorDto) {
        final Author savedAuthor = this.authorService.save(converter.convert(authorDto, Author.class));
        return converter.convert(savedAuthor, AuthorDto.class);
    }

    @PutMapping(value = "")
    public AuthorDto updateAuthor(@RequestBody @Valid AuthorDto authorDto) {
        final Author save = this.authorService.save(converter.convert(authorDto, Author.class));
        return converter.convert(save, AuthorDto.class);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable("id") final Author author) {
        this.authorService.delete(author);
    }

    @GetMapping(value = "")
    public List<AuthorDto> getAllUsers() {
        return converter.convertList(this.authorService.getAll(), AuthorDto.class);
    }
}
