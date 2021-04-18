package compulsory.queries;

import compulsory.dao.Genre;
import compulsory.person.Actor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SelectActor extends Query {
    private final String getActorByID = "SELECT * FROM ACTORS WHERE id=";
    private final String getActorByName = "SELECT * FROM ACTORS WHERE name=";
    private final String insertActor = "INSERT INTO GENRES (ID, NAME) VALUES (?,?)";
    private final String getAllActors = "SELECT * FROM GENRES";

    public SelectActor() throws SQLException {
    }

    public int getActorMaxId() throws SQLException {
        int maxId = -1;
        String selectMaxId = "SELECT MAX(ID) FROM ACTORS";
        queryResult = stmt.executeQuery(selectMaxId);
        if (queryResult.next())
            maxId = queryResult.getInt(1);
        return maxId + 1;
    }

    public void insert(String name) throws SQLException {
        PreparedStatement preparedStmt = driver.getConnection().prepareStatement(insertActor);
        preparedStmt.setInt(1, getActorMaxId());
        preparedStmt.setString(2, name);
        preparedStmt.executeUpdate();
    }

    public Actor ActorNameQuery(String name) throws SQLException {
        String query = getActorByName + "\'" + name + "\'";
        queryResult = stmt.executeQuery(query);
        Actor actor = getActorQueryResult();
        return actor;
    }

    public Actor actorIdQuery(int id) throws SQLException {
        String query = getActorByID + id;
        queryResult = stmt.executeQuery(query);
        Actor actor = getActorQueryResult();
        return actor;
    }

    public Actor getActorQueryResult() throws SQLException {
        if (queryResult.next()) {
            return getQueryActor();
        }
        return null;
    }

    public Actor getQueryActor() throws SQLException {
        Actor actor = new Actor();
        actor.setId(queryResult.getInt("id"));
        actor.setName(queryResult.getString("name"));
        return actor;
    }

    public List<Actor> getAllActors() throws SQLException {
        queryResult = stmt.executeQuery(getAllActors);
        List<Actor> allActors = new ArrayList<>();
        while (queryResult.next()) {
            allActors.add(getQueryActor());
        }
        return allActors;
    }
}
