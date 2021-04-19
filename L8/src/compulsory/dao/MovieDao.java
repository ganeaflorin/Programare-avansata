package compulsory.dao;

import compulsory.queries.SelectMovie;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class MovieDao {
    private SelectMovie query;

    public MovieDao() throws SQLException {
        query = new SelectMovie();
    }

    public void find(int id) throws SQLException {
        System.out.println(query.movieIdQuery(id).toString());
    }

    public void find(String title) throws SQLException {
        System.out.println(query.movieTitleQuery(title).toString());
    }

    public void insert(String title, Date releaseDate, int duration, int score) throws SQLException {
        if (query.movieTitleQuery(title) != null)
            System.out.println("Movie " + title + " already in database");
        else {
            Movie movie = new Movie(title, releaseDate, duration, score);
            query.insert(movie.getTitle(), movie.getDate(), movie.getDuration(), movie.getScore());
        }
    }

    public List<Movie> getAllMovies() throws SQLException {
        return query.getAllMovies();
    }

}
