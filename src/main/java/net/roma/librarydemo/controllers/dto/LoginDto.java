package net.roma.librarydemo.controllers.dto;


import lombok.*;

@Data
@RequiredArgsConstructor
public class LoginDto {

    private String username;
    private String password;

}
