package net.roma.librarydemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
