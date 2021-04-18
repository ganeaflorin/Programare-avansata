package compulsory.queries;

import compulsory.connection.Driver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Query {
    protected Driver driver;
    protected Statement stmt;
    protected ResultSet queryResult;
    protected PreparedStatement preparedStmt;
    public Query() throws SQLException {
        driver = Driver.getDriver();
        stmt = driver.getConnection().createStatement();
    }

}
