package net.roma.librarydemo.controllers.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class UserBookDto extends AbstractDto{

    private Long idUser;
    private Long idBook;
    private LocalDate creationDate;
    private boolean isDebtor;

}
