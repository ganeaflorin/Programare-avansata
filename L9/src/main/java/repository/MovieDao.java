package repository;

import jdbc.dao.Movie;
import jdbc.queries.SelectMovie;
import repository.AbstractRepository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class MovieDao extends AbstractRepository<Movie> {
    private SelectMovie query;

    public MovieDao() throws SQLException {
        query = new SelectMovie();
    }

    public Movie findById(long id) throws SQLException {
        return query.movieIdQuery((int) id);
//        System.out.println(query.movieIdQuery(id).toString());
    }

    public void findByName(String title) throws SQLException {
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
