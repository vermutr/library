package net.roma.librarydemo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.model.Book;
import net.roma.librarydemo.repository.BookRepository;
import net.roma.librarydemo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book getById(Long id) {
        log.info("In UserServiceImpl getById {}", id);
        return bookRepository.getOne(id);
    }

    @Override
    public Book save(Book book) {
        log.info("In UserServiceImpl save {}", book);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        log.info("In UserServiceImpl delete {}", book);
        bookRepository.delete(book);
    }

    @Override
    public List<Book> getAll() {
        log.info("In UserServiceImpl getAll");
        return bookRepository.findAll();
    }

}
