package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
    private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String user = "student";
    private final String password = "STUDENT";
    private Connection connection;

    private Driver() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static Driver getDriver() {
        Driver driver = new Driver();
        return driver;
    }

    public Connection getConnection() {
        return connection;
    }
}
