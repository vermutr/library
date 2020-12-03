package net.roma.librarydemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "authors")
public class Author extends AbstractEntity {

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Book> books;
}
