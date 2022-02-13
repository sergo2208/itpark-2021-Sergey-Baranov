package lesson24;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {

    @CsvBindByName(column = "isbn")
    private String isbn;
    @CsvBindByName(column = "Title")
    private String title;
    @CsvBindByName(column = "Author")
    private String author;
    @CsvBindByName(column = "PageCount")
    private Integer pageCount;
    @CsvBindByName(column = "Genre")
    private String genre;
    @CsvBindByName(column = "URL")
    private String url;

}
