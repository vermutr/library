package net.roma.librarydemo.service;

import net.roma.librarydemo.model.Author;

import java.util.List;

public interface AuthorService {

    Author getById(Long id);

    Author save(Author author);

    void delete(Author author);

    List<Author> getAll();

}
