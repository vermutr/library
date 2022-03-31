package net.roma.librarydemo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.model.UserBook;
import net.roma.librarydemo.repository.UserBookRepository;
import net.roma.librarydemo.service.UserBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserBookServiceImpl implements UserBookService {

    private final UserBookRepository userBookRepository;

    @Override
    public UserBook save(UserBook userBook) {
        return userBookRepository.save(userBook);
    }

    @Override
    public void deleteUserBookByUserIdAndBookId(Long userId, Long bookId) {
        userBookRepository.deleteUserBookByUserIdAndBookId(userId, bookId);
    }

    @Override
    public List<UserBook> getAll() {
        return userBookRepository.findAll();
    }

}
