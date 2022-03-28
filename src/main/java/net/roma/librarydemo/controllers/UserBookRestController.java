package net.roma.librarydemo.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.configutaion.DetailsConverter;
import net.roma.librarydemo.controllers.dto.BookDto;
import net.roma.librarydemo.controllers.dto.UserBookDto;
import net.roma.librarydemo.model.Book;
import net.roma.librarydemo.model.UserBook;
import net.roma.librarydemo.service.UserBookService;
import net.roma.librarydemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserBookRestController {

    private final UserBookService userBookService;
    private final UserService userService;
    private final DetailsConverter detailsConverter;

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public UserBookDto saveUserBook(Principal principal, @RequestParam final String bookId) {
        Long userId = userService.findByUsername(principal.getName()).get().getId();
        UserBook userBook = new UserBook();
        userBook.setIdBook(Long.parseLong(bookId));
        userBook.setIdUser(userId);
        userBook.setCreationDate(LocalDateTime.now());
        final UserBook savedUserBook = this.userBookService.save(userBook);
        return detailsConverter.convert(savedUserBook, UserBookDto.class);
    }

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public List<BookDto> getUserBooks(Principal principal) {
        Long userId = userService.findByUsername(principal.getName()).get().getId();
        final List<Book> userBooks = this.userBookService.getBooksByUserId(userId);
        return detailsConverter.convertList(userBooks, BookDto.class);
    }

}
