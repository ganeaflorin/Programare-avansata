package compulsory.queries;

import compulsory.person.Director;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectDirector extends Query {
    private final String getDirectorByID = "SELECT * FROM DIRECTORS WHERE id=";
    private final String getDirectorByName = "SELECT * FROM DIRECTORS WHERE name=";
    private final String insertDirector = "INSERT INTO DIRECTORS (ID, NAME) VALUES (?,?)";
    private final String getAllDirectors = "SELECT * FROM DIRECTORS";

    public SelectDirector() throws SQLException {
    }

    public int getDirectorMaxId() throws SQLException {
        int maxId = -1;
        String selectMaxId = "SELECT MAX(ID) FROM DIRECTORS";
        queryResult = stmt.executeQuery(selectMaxId);
        if (queryResult.next())
            maxId = queryResult.getInt(1);
        return maxId + 1;
    }

    public void insert(String name) throws SQLException {
        PreparedStatement preparedStmt = driver.getConnection().prepareStatement(insertDirector);
        preparedStmt.setInt(1, getDirectorMaxId());
        preparedStmt.setString(2, name);
        preparedStmt.executeUpdate();
    }

    public Director directorNameQuery(String name) throws SQLException {
        String query = getDirectorByName + "\'" + name + "\'";
        queryResult = stmt.executeQuery(query);
        Director director = getDirectorQueryResult();
        return director;
    }

    public Director directorIdQuery(int id) throws SQLException {
        String query = getDirectorByID + id;
        queryResult = stmt.executeQuery(query);
        Director director = getDirectorQueryResult();
        return director;
    }

    public Director getDirectorQueryResult() throws SQLException {
        if (queryResult.next()) {
            return getQueryDirector();
        }
        return null;
    }

    public Director getQueryDirector() throws SQLException {
        Director director = new Director();
        director.setId(queryResult.getInt("id"));
        director.setName(queryResult.getString("name"));
        return director;
    }

    public List<Director> getAllDirectors() throws SQLException {
        queryResult = stmt.executeQuery(getAllDirectors);
        List<Director> allDirectors = new ArrayList<>();
        while (queryResult.next()) {
            allDirectors.add(getQueryDirector());
        }
        return allDirectors;
    }
}
