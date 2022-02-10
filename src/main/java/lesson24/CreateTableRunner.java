package lesson24;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableRunner {
    private static final String dbDriver = "org.postgresql.Driver";
    private static final String dbURL = "jdbc:postgresql://localhost:5432/pgbd";
    private static final String login = "pguser";
    private static final String password = "123";


    @SneakyThrows
    public static void main(String[] args) {
        Class.forName(dbDriver);
        Connection connection = DriverManager.getConnection(dbURL, login, password);
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE Books (id INTEGER not null, " +
                "isbn VARCHAR not null, " +
                "Name VARCHAR not null, " +
                "Author VARCHAR not null, " +
                "NumberOfPages INTEGER, " +
                "TheYearsOfPublishing INTEGER, " +
                "Genre VARCHAR, " +
                "LinkToOnlineStore VARCHAR not null, " +
                "PRIMARY KEY (id))";
        statement.executeUpdate(sql);
    }
}
