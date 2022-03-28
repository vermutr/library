package net.roma.librarydemo.controllers;


import lombok.RequiredArgsConstructor;
import net.roma.librarydemo.configutaion.DetailsConverter;
import net.roma.librarydemo.configutaion.security.jwt.JwtTokenProvider;
import net.roma.librarydemo.controllers.dto.LoginDto;
import net.roma.librarydemo.controllers.dto.UserDto;
import net.roma.librarydemo.model.User;
import net.roma.librarydemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/login")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final DetailsConverter converter;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            String username = loginDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            final User user = userService
                    .findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));

            String token = jwtTokenProvider.createToken(username);
            final Map<Object, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", converter.convert(user, UserDto.class));

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
