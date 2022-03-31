package net.roma.librarydemo.service;

import net.roma.librarydemo.model.UserBook;

import java.util.List;

public interface UserBookService {

    UserBook save(UserBook userBook);

    void deleteUserBookByUserIdAndBookId(Long userId, Long bookId);

    List<UserBook> getAll();

}
