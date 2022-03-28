package net.roma.librarydemo.repository;

import net.roma.librarydemo.model.Book;
import net.roma.librarydemo.model.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    @Query("select bk from Book bk inner join UserBook ub on bk.id = ub.idBook " +
            "inner join User lu on ub.idUser = lu.id\n" +
            "where lu.id = ?1")
    List<Book> getBooksByUserId(Long userId);

    @Query("select ub from UserBook ub where ub.idUser = ?1")
    List<UserBook> findUserBooksByUserId(Long userId);

}
