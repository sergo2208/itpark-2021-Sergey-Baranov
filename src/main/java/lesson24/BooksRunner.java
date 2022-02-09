package lesson24;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;
import java.util.function.Consumer;

public class BooksRunner {

    private static final Configuration config;

    static {
        config = new Configuration();
        config.configure();
    }

    public static void main(String[] args) {
        System.out.println("Введите название книги или имя автора для поиска результата");
        Scanner in= new Scanner(System.in);
        String str = in.next();
        runInsideSession(session -> {
            Query<Books> searchBook = session.createQuery("from Book where name like :name or author like :author", Books.class);
            searchBook.setParameter("name", "%" + str + "%");
            searchBook.setParameter("author", "%" + str + "%");
            searchBook.getResultList().forEach(System.out::println);
        });
    }

    public static Session getCurrentSessionFromConfig() {
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    public static void runInsideSession(Consumer<Session> consumer) {
        try (final Session session = getCurrentSessionFromConfig()) {
            Transaction transaction = session.beginTransaction();
            consumer.accept(session);
            transaction.commit();
        }
    }
}
