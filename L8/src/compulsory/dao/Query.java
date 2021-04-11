package compulsory.dao;

import compulsory.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Query {
    protected Driver driver;
    protected Statement stmt;
    protected ResultSet queryResult;

    public Query() throws SQLException {
        driver = Driver.getDriver();
        stmt = driver.getConnection().createStatement();
    }

}
