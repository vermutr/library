package net.roma.librarydemo.repository;

import net.roma.librarydemo.model.Author;
import net.roma.librarydemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
