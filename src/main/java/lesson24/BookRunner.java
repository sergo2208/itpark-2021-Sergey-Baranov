package lesson24;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;


public class BookRunner {

    public static void main(String[] args) {
        System.out.println("Сперва удалим таблицы книг и их авторов, если таковые имеются");
        BookDb.dropBooksAndAuthorsIfExists();
        System.out.println("Создадим таблицы книг и их авторов");
        BookDb.createBooksAndAuthors();
        System.out.println("Наполним таблицы данными из ресурсного файла");
        CsvMapper.getBookInfo().stream().map(authorAndBook -> Pair.of(
                new Author(authorAndBook.getAuthor()),
                new Title(authorAndBook.getIsbn(),
                        authorAndBook.getTitle(),
                        authorAndBook.getUrl(),
                        authorAndBook.getPageCount(),
                        authorAndBook.getGenre()))).forEach(pair ->
                {
                    final Optional<Integer> author = BookDb.insertAuthor(pair.getLeft());
                    BookDb.insertBook(author.orElse(null), pair.getRight());
                }
        );
        System.out.println("Выполнение программы завершено");
    }
}
