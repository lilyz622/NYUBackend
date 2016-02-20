package record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Record {
    protected static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            final String username = System.getenv("POSTGRES_USERNAME");
            final String password = System.getenv("POSTGRES_PASSWORD");

            final String host = System.getenv("POSTGRES_HOST");
            final String databaseName = System.getenv("POSTGRES_DB_NAME");

            final String sslString = "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

            String dbUrl = String.format("jdbc:postgresql://%s/%s%s",
                    host,
                    databaseName,
                    sslString);

            return DriverManager.getConnection(dbUrl, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}