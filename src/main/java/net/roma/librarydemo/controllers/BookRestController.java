package net.roma.librarydemo.controllers;


import lombok.RequiredArgsConstructor;
import net.roma.librarydemo.configutaion.DetailsConverter;
import net.roma.librarydemo.controllers.dto.BookDto;
import net.roma.librarydemo.model.Book;
import net.roma.librarydemo.service.BookService;
import net.roma.librarydemo.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/book/")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookRestController {

    private final BookService bookService;
    private final DetailsConverter converter;
    private final UserService userService;

    @GetMapping(value = "{id}")
    public BookDto getBook(@PathVariable("id") @NotNull final Long bookId) {
        return converter.convert(this.bookService.getById(bookId), BookDto.class);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto saveBook(@RequestBody @NotNull @Valid final BookDto bookDto) {
        final Book savedBook = this.bookService.save(converter.convert(bookDto, Book.class));
        return converter.convert(savedBook, BookDto.class);
    }

    @PutMapping(value = "")
    public BookDto updateBook(@RequestBody @Valid BookDto bookDto) {
        final Book save = this.bookService.save(converter.convert(bookDto, Book.class));
        return converter.convert(save, BookDto.class);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("id") final Book book) {
        this.bookService.delete(book);
    }

    @GetMapping(value = "")
    public List<BookDto> getAllBooks(@PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
            return converter.convertList(this.bookService.getAll(pageable), BookDto.class);
    }

    @GetMapping(value = "basket")
    public List<BookDto> getAllBasketBooks(Principal principal) {
        Long userId = userService.findByUsername(principal.getName()).get().getId();
        final List<Book> userBooks = this.bookService.getBooksByUserId(userId);
        return converter.convertList(userBooks, BookDto.class);
    }


}
