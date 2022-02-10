package lesson24;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BooksInATableRunner {

    private static final String dbURL = "jdbc:postgresql://localhost:5432/pgbd";
    private static final String login = "pguser";
    private static final String password = "123";
    private static final String insertBooks = "INSERT INTO Books (id, isbn, Name, Author, NumberOfPages, TheYearsOfPublishing," +
            "Genre, LinkToOnlineStore) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String selectBooks = "SELECT id FROM Books WHERE id != null";
    private static final String deleteBooks = "TRUNCATE TABLE Books";

    @SneakyThrows
    public static void main(String[] args) {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(dbURL, login, password);
        PreparedStatement statement;
        FileReader csvFile = new FileReader("books.csv");
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream = new Scanner(csvFile);
        while (inputStream.hasNext()) {
            String line = inputStream.nextLine();
            String[] values = line.split(";");
            lines.add(Arrays.asList(values));
        }
        inputStream.close();
        statement = connection.prepareStatement(selectBooks);
        if (statement.execute()) {
            Statement stat = connection.createStatement();
            stat.executeUpdate(deleteBooks);
        }
        statement = connection.prepareStatement(insertBooks);
        for (List<String> line: lines) {
            statement.setInt(1, Integer.parseInt(line.get(0)));
            statement.setString(2, line.get(1));
            statement.setString(3, line.get(2));
            statement.setString(4, line.get(3));
            statement.setInt(5, Integer.parseInt(line.get(4)));
            statement.setInt(6, Integer.parseInt(line.get(5)));
            statement.setString(7, line.get(6));
            statement.setString(8, line.get(7));
            statement.executeUpdate();
        }
    }
}
