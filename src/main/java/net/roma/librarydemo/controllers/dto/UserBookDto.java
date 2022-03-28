package net.roma.librarydemo.controllers.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class UserBookDto extends AbstractDto{

    private Long idUser;
    private Long idBook;
    private LocalDateTime creationDate;
    private boolean isDebtor;

}
