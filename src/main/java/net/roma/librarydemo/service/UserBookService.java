package net.roma.librarydemo.service;

import net.roma.librarydemo.model.Book;
import net.roma.librarydemo.model.UserBook;

import java.util.List;

public interface UserBookService {

    List<Book> getBooksByUserId(Long userId);

    List<UserBook> findUserBooksByUserId(Long userId);

    UserBook save(UserBook userBook);

    void delete(UserBook userBook);

}
