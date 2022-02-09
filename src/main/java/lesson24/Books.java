package lesson24;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Books")
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor

public class Books {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "Name")
    private String name;
    @Column(name = "Author")
    private String author;
    @Column(name = "NumberOfPages")
    private Integer numberOfPages;
    @Column(name = "TheYearsOfPublishing")
    private Integer theYearsOfPublishing;
    @Column(name = "Genre")
    private String genre;
    @Column(name = "LinkToOnlineStore")
    private String linkToOnlineStore;


}
