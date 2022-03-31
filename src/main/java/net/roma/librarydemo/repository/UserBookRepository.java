package net.roma.librarydemo.repository;

import net.roma.librarydemo.model.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserBookRepository extends JpaRepository<UserBook, Long> {

    @Transactional
    @Modifying
    @Query("delete from UserBook ub where ub.idUser = ?1 and ub.idBook = ?2")
    void deleteUserBookByUserIdAndBookId(Long userId, Long bookId);

}
