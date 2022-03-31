package net.roma.librarydemo.repository;

import net.roma.librarydemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select bk from Book bk inner join UserBook ub on bk.id = ub.idBook " +
            "inner join User lu on ub.idUser = lu.id\n" +
            "where lu.id = ?1")
    List<Book> getBooksByUserId(Long userId);

}
