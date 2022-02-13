package lesson24;

import java.io.IOException;
import java.util.Properties;

public class DbRunner {
    private static final Properties DB_SETTINGS = new Properties();

    static {
        try {
            DB_SETTINGS.load(DbRunner.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
