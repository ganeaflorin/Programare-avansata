package compulsory;

import compulsory.dao.Query;
import compulsory.dao.Select;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Select select = new Select();
//        select.titleQuery("The Godfather");
        select.idQuery(1);
    }
}
