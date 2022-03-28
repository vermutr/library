package net.roma.librarydemo.controllers.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends AbstractDto {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

}
