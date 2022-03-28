package net.roma.librarydemo.controllers.dto;

import lombok.*;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public abstract class AbstractDto implements Serializable {

    private Long id;

}
