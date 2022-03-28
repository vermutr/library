package net.roma.librarydemo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "user_book")
public class UserBook extends AbstractEntity {

    private Long idUser;

    private Long idBook;

    private LocalDateTime creationDate;

    @Column(columnDefinition = "boolean default false")
    private boolean isDebtor;

}
