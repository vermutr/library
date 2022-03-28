package net.roma.librarydemo.service;

import net.roma.librarydemo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getById(Long id);

    User save(User userDto);

    void delete(User user);

    List<User> getAll();

    Optional<User> findByUsername(String username);

}
