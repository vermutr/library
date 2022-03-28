package net.roma.librarydemo.repository;

import net.roma.librarydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT usr FROM User usr WHERE usr.username = ?1")
    Optional<User> findByUsername(String username);

}
