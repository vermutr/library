package net.roma.librarydemo.configutaion.security;

import lombok.extern.slf4j.Slf4j;
import net.roma.librarydemo.configutaion.security.jwt.JwtUserFactory;
import net.roma.librarydemo.model.User;
import net.roma.librarydemo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtUserDetailsService(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));

        return JwtUserFactory.create(user);
    }
}

