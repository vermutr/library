package net.roma.librarydemo.service;

import net.roma.librarydemo.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getById(Long id);

    User save(User userDto);

    void delete(User user);

    List<User> getAll(Pageable pageable);

    Optional<User> findByUsername(String username);

}
