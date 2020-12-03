package net.roma.librarydemo.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "books")
public class Book extends AbstractEntity{

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "code")
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    @JsonManagedReference
    private Author authors;
}
