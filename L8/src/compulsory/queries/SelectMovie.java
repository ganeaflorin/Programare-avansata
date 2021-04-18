package compulsory.queries;

import compulsory.dao.Movie;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectMovie extends Query {
    private final String getMovieByName = "SELECT * FROM MOVIES WHERE title=";
    private final String getMovieByID = "SELECT * FROM MOVIES WHERE id=";
    private final String insertMovie = "INSERT INTO MOVIES (ID, TITLE, RELEASE_DATE, DURATION, SCORE) VALUES (?,?, ?, ?, ?)";
    private final String getAllMovies = "SELECT * FROM MOVIES";

    public SelectMovie() throws SQLException {
        super();

    }

    public int getMovieMaxId() throws SQLException {
        int maxId = -1;
        String selectMaxId = "SELECT MAX(ID) FROM MOVIES";
        queryResult = stmt.executeQuery(selectMaxId);
        if (queryResult.next())
            maxId = queryResult.getInt(1);
        return maxId + 1;
    }

    public void insert(String title, Date releaseDate, int duration, int score) throws SQLException {
        PreparedStatement preparedStmt = driver.getConnection().prepareStatement(insertMovie);
        preparedStmt.setInt(1, getMovieMaxId());
        preparedStmt.setString(2, title);
        preparedStmt.setDate(3, (java.sql.Date) releaseDate);
        preparedStmt.setInt(4, duration);
        preparedStmt.setInt(5, score);
        preparedStmt.executeUpdate();
    }

    public Movie movieTitleQuery(String title) throws SQLException {
        String query = getMovieByName + "\'" + title + "\'";
        queryResult = stmt.executeQuery(query);
        Movie movie = getMovieQueryResult();
        return movie;
    }

    public Movie movieIdQuery(int id) throws SQLException {
        String query = getMovieByID + id;
        queryResult = stmt.executeQuery(query);
        Movie movie = getMovieQueryResult();
        return movie;
    }


    public Movie getMovieQueryResult() throws SQLException {
        if (queryResult.next()) {
            return getQueryMovie();
        }
        return null;
    }

    public Movie getQueryMovie() throws SQLException {
        Movie movie = new Movie();
        movie.setId(queryResult.getInt("id"));
        movie.setDuration(queryResult.getInt("duration"));
        movie.setScore(queryResult.getInt("score"));
        movie.setTitle(queryResult.getString("title"));
        movie.setDate(queryResult.getDate("release_date"));
        return movie;
    }

    public List<Movie> getAllMovies() throws SQLException {
        queryResult = stmt.executeQuery(getAllMovies);
        List<Movie> allMovies = new ArrayList<>();
        while (queryResult.next()) {
            allMovies.add(getQueryMovie());
        }
        return allMovies;
    }


}

