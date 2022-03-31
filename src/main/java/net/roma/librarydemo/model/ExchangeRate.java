package net.roma.librarydemo.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ExchangeRate {

    private LocalDate data;
    private String cena;

}
