package lesson24;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Title {
    private String isbn;
    private String title;
    private String url;
    private Integer pageCount;
    private String genre;


}