package compulsory.dao;

import compulsory.queries.SelectMovie;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class MovieDao {
    private SelectMovie select;

    public MovieDao() throws SQLException {
        select = new SelectMovie();
    }

    public void find(int id) throws SQLException {
        System.out.println(select.movieIdQuery(id).toString());
    }

    public void find(String title) throws SQLException {
        System.out.println(select.movieTitleQuery(title).toString());
    }

    public void insert(String title, Date releaseDate, int duration, int score) throws SQLException {
        if (select.movieTitleQuery(title) != null)
            System.out.println("Movie " + title + " already in database");
        else {
            Movie movie = new Movie(title, releaseDate, duration, score);
            select.insert(movie.getTitle(), movie.getDate(), movie.getDuration(), movie.getScore());
        }
    }

    public List<Movie> getAllMovies() throws SQLException {
        return select.getAllMovies();
    }

}
