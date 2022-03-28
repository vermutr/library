package net.roma.librarydemo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.model.Book;
import net.roma.librarydemo.model.UserBook;
import net.roma.librarydemo.repository.UserBookRepository;
import net.roma.librarydemo.service.UserBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserBookServiceImpl implements UserBookService {

    private final UserBookRepository userBookRepository;

    @Override
    public List<Book> getBooksByUserId(Long userId) {
        checkExpiredDate(userId);
        return userBookRepository.getBooksByUserId(userId);
    }

    @Override
    public List<UserBook> findUserBooksByUserId(Long userId) {
        return userBookRepository.findUserBooksByUserId(userId);
    }

    @Override
    public UserBook save(UserBook userBook) {
        return userBookRepository.save(userBook);
    }

    @Override
    public void delete(UserBook userBook) {
        userBookRepository.delete(userBook);
    }

    void checkExpiredDate(Long userId) {
        userBookRepository
                .findUserBooksByUserId(userId)
                .forEach(e -> {
                    if (e.getCreationDate().plusDays(3).isBefore(LocalDateTime.now())) {
                        e.setDebtor(true);
                        save(e);
                    }
                });
    }
}
