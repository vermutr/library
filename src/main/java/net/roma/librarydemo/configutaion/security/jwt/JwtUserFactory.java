package net.roma.librarydemo.configutaion.security.jwt;

import net.roma.librarydemo.model.Role;
import net.roma.librarydemo.model.Status;
import net.roma.librarydemo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                mapToGrantAuthority(user.getRole())
        );
    }

    private static List<GrantedAuthority> mapToGrantAuthority(Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

}
