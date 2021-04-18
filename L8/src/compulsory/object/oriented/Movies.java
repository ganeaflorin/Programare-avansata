package compulsory.object.oriented;

import compulsory.dao.Genre;
import compulsory.dao.GenreDao;
import compulsory.dao.Movie;
import compulsory.dao.MovieDao;
import compulsory.queries.JoinQueries;

import java.sql.SQLException;
import java.util.List;

public class Movies {
    private List<Movie> movies;
    private MovieDao movieDao;

    public Movies() throws SQLException {
        movieDao = new MovieDao();
        movies = movieDao.getAllMovies();
    }

    public void printAllMovies() {
        for (Movie movie : movies)
            System.out.println(movie);
    }

    public void setMoviesData() throws SQLException {
        JoinQueries getMovieData = new JoinQueries();
        for (Movie movie : movies) {
            movie.setGenresList(getMovieData.getMovieGenres(movie.getId()));
            movie.setActorsList(getMovieData.getMovieActors(movie.getId()));
            movie.setDirectorsList(getMovieData.getMovieDirectors(movie.getId()));
        }
    }
}
