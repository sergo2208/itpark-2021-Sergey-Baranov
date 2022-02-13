package lesson24;


import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@UtilityClass

public class BookDb {

    private final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(DbRunner.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows(SQLException.class)
    public void dropBooksAndAuthorsIfExists() {
        try (final Connection connection = getConnection();
             final PreparedStatement dropIfExistsTableBooks = connection.prepareStatement("drop table if exists books");
             final PreparedStatement dropIfExistsTableAuthors = connection.prepareStatement("drop table if exists authors")) {
            dropIfExistsTableBooks.execute();
            dropIfExistsTableAuthors.execute();
        }
    }

    @SneakyThrows(SQLException.class)
    public void createBooksAndAuthors() {
        try (final Connection connection = getConnection();
             final PreparedStatement dropIfExistsTableBooks = connection.prepareStatement(
                     """
                             create table authors
                             (
                                 id int auto_increment,
                                 name varchar(100) not null unique,
                                 constraint authors_pk
                                     primary key (id)
                             );
                             """
             );
             final PreparedStatement dropIfExistsTableAuthors = connection.prepareStatement(
                     """
                             create table books
                             (
                             	id int auto_increment,
                             	isbn varchar(17) not null unique,
                             	title varchar(100) not null,
                             	url varchar(4000) null,
                             	genre varchar(20) null,
                             	pageCount int null,
                             	author_id int null,
                             	constraint books_pk
                             		primary key (id),
                             	constraint books_authors_id_fk
                             		foreign key (author_id) references authors (id)
                             );
                             """
             )) {
            dropIfExistsTableBooks.execute();
            dropIfExistsTableAuthors.execute();
        }
    }

    @SneakyThrows(SQLException.class)
    public Optional<Integer> insertAuthor(Author author) {
        final String authorName = author.getAuthorName();

        try (final Connection connection = getConnection();
             final PreparedStatement authorStatement = connection.prepareStatement("insert into authors(name) values(?)");
             final PreparedStatement searchAuthorStatement = connection.prepareStatement("select id from authors where name = ?")
        ) {
            authorStatement.setString(1, authorName);
            authorStatement.execute();
            searchAuthorStatement.setString(1, authorName);
            final ResultSet resultSet = searchAuthorStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(resultSet.getInt("id"));
            }
        }
        return Optional.empty();
    }

    @SneakyThrows(SQLException.class)
    public void insertBook(Integer authorId, Title book) {
        try (final Connection connection = getConnection();
             final PreparedStatement fullBookStatement = connection.prepareStatement(
                     """
                             insert into books(isbn, title, url, genre, pageCount, author_id)
                             values (?, ?, ?, ?, ?, ?)
                             """
             );
             final PreparedStatement bookStatementWithoutAuthor = connection.prepareStatement(
                     """
                             insert into books(isbn, title, url, genre, pageCount)
                             values (?, ?, ?, ?, ?, )
                             """
             )
        ) {
            if (authorId != null) {
                fullBookStatement.setString(1, book.getIsbn());
                fullBookStatement.setString(2, book.getTitle());
                fullBookStatement.setString(3, book.getUrl());
                fullBookStatement.setString(4, book.getGenre());
                fullBookStatement.setInt(5, book.getPageCount());
                fullBookStatement.setInt(6, authorId);
                fullBookStatement.execute();
            } else {
                bookStatementWithoutAuthor.setString(1, book.getIsbn());
                bookStatementWithoutAuthor.setString(2, book.getTitle());
                bookStatementWithoutAuthor.setString(3, book.getUrl());
                fullBookStatement.setString(4, book.getGenre());
                fullBookStatement.setInt(5, book.getPageCount());
                bookStatementWithoutAuthor.execute();
            }
        }
    }

    @SneakyThrows(SQLException.class)
    public List<Books> searchByTitleOrAuthorName(String text) {
        try (final Connection connection = getConnection();
             final PreparedStatement searchStatement = connection.prepareStatement("""
                         select b.isbn, b.title, b.url, b.genre, b.pageCount, a.name from books b
                         left join authors a
                         on b.author_id = a.id
                         where lower(b.title) like ? or lower(a.name) like ?
                         order by b.id
                     """)
        ) {
            searchStatement.setString(1, "%" + text + "%");
            searchStatement.setString(2, "%" + text + "%");
            final ResultSet resultSet = searchStatement.executeQuery();
            List<Books> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Books(
                        resultSet.getString("isbn"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.wasNull() ? null : resultSet.getInt("pageCount"),
                        resultSet.getString("genre"),
                        resultSet.getString("url")));
            }
            return result;
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));
    }
}
