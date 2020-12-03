package net.roma.librarydemo.controllers;

import lombok.RequiredArgsConstructor;
import net.roma.librarydemo.configutaion.DetailsConverter;
import net.roma.librarydemo.controllers.dto.UserDto;
import net.roma.librarydemo.model.User;
import net.roma.librarydemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/user/")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final DetailsConverter converter;

    @GetMapping(value = "{id}")
    public UserDto getUser(@PathVariable("id") @NotNull final Long userId) {
        return converter.convert(this.userService.getById(userId), UserDto.class);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@RequestBody @NotNull @Valid final UserDto userDto) {
        final User savedUser = this.userService.save(converter.convert(userDto, User.class));
        return converter.convert(savedUser, UserDto.class);
    }

    @PutMapping(value = "")
    public UserDto updateUser(@RequestBody @Valid UserDto userDto) {
        final User save = this.userService.save(converter.convert(userDto, User.class));
        return converter.convert(save, UserDto.class);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") final User user) {
        this.userService.delete(user);
    }

    @GetMapping(value = "")
    public List<UserDto> getAllUsers() {
        return converter.convertList(this.userService.getAll(), UserDto.class);
    }
}
