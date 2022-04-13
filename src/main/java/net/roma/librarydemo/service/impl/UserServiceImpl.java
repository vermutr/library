package net.roma.librarydemo.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.model.Role;
import net.roma.librarydemo.model.Status;
import net.roma.librarydemo.model.User;
import net.roma.librarydemo.repository.UserRepository;
import net.roma.librarydemo.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getById(Long id) {
        log.info("In UserServiceImpl getById {}", id);
        return userRepository.getById(id);
    }

    @Override
    public User save(User user) {
        log.info("In UserServiceImpl save {}", user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        log.info("In UserServiceImpl delete {}", user);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll(Pageable pageable) {
        log.info("In UserServiceImpl getAll");
        return userRepository
                .findAll(pageable)
                .getContent();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
