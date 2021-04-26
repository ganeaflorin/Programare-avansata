package jdbc.queries;

import jdbc.dao.Genre;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SelectGenre extends Query {
    private final String getGenreByID = "SELECT * FROM GENRES WHERE id=";
    private final String getGenreByName = "SELECT * FROM GENRES WHERE name=";
    private final String insertGenre = "INSERT INTO GENRES (ID, NAME) VALUES (?,?)";
    private final String getAllGenres = "SELECT * FROM GENRES";

    public SelectGenre() throws SQLException {
    }

    public int getGenreMaxId() throws SQLException {
        int maxId = -1;
        String selectMaxId = "SELECT MAX(ID) FROM GENRES";
        queryResult = stmt.executeQuery(selectMaxId);
        if (queryResult.next())
            maxId = queryResult.getInt(1);
        return maxId + 1;
    }

    public void insert(String name) throws SQLException {
        name = name.toUpperCase(Locale.ROOT);
        PreparedStatement preparedStmt = driver.getConnection().prepareStatement(insertGenre);
        preparedStmt.setInt(1, getGenreMaxId());
        preparedStmt.setString(2, name);
        preparedStmt.executeUpdate();
    }

    public Genre genreNameQuery(String name) throws SQLException {
        name = name.toUpperCase(Locale.ROOT);
        String query = getGenreByName + "\'" + name + "\'";
        queryResult = stmt.executeQuery(query);
        Genre genre = getGenreQueryResult();
        return genre;
    }

    public Genre genreIdQuery(int id) throws SQLException {
        String query = getGenreByID + id;
        queryResult = stmt.executeQuery(query);
        Genre genre = getGenreQueryResult();
        return genre;
    }

    public Genre getGenreQueryResult() throws SQLException {
        if (queryResult.next()) {
            return getQueryGenre();
        }
        return null;
    }

    public Genre getQueryGenre() throws SQLException {
        Genre genre = new Genre();
        genre.setId(queryResult.getInt("id"));
        genre.setName(queryResult.getString("name"));
        return genre;
    }

    public List<Genre> getAllGenres() throws SQLException {
        queryResult = stmt.executeQuery(getAllGenres);
        List<Genre> allGenres = new ArrayList<>();
        while (queryResult.next()) {
            allGenres.add(getQueryGenre());
        }
        return allGenres;
    }
}
