package compulsory.dao;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select extends Query {
    private final String getByName = "SELECT * FROM MOVIES WHERE TITLE=";
    private final String getByID = "SELECT * FROM MOVIES WHERE ID=";

    public Select() throws SQLException {
        super();

    }

    public void titleQuery(String title) throws SQLException {
        String query = getByName + "\'" + title + "\'";
        queryResult = stmt.executeQuery(query);
        getQueryResult();
    }

    public void idQuery(int id) throws SQLException {
        String query = getByID + id;
        queryResult = stmt.executeQuery(query);
        getQueryResult();
    }

    public void getQueryResult() throws SQLException {
        int count = 0;
        List<String> columnNames = new ArrayList<>();
        ResultSetMetaData metaData = queryResult.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++)
            columnNames.add(metaData.getColumnName(columnIndex));

        while (queryResult.next()) {
            count++;
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                System.out.println(columnNames.get(columnIndex - 1) + ": " + queryResult.getString(columnIndex));
            }
        }
        if (count == 0) System.out.println("No data found.");
    }
}
