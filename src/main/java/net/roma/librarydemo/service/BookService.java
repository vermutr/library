package net.roma.librarydemo.service;

import net.roma.librarydemo.model.Book;

import java.util.List;

public interface BookService {
    Book getById(Long id);

    Book save(Book book);

    void delete(Book book);

    List<Book> getAll();

}
