package net.roma.librarydemo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.model.Author;
import net.roma.librarydemo.repository.AuthorRepository;
import net.roma.librarydemo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author getById(Long id) {
        log.info("In UserServiceImpl getById {}", id);
        return authorRepository.getOne(id);
    }

    @Override
    public Author save(Author author) {
        log.info("In UserServiceImpl save {}", author);
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        log.info("In UserServiceImpl delete {}", author);
        authorRepository.delete(author);
    }

    @Override
    public List<Author> getAll() {
        log.info("In UserServiceImpl getAll");
        return authorRepository.findAll();
    }

}
