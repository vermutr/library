package net.roma.librarydemo.repository;

import net.roma.librarydemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
