package compulsory.dao;

import compulsory.imdb.dataset.Imdb;
import compulsory.object.oriented.Genres;
import compulsory.object.oriented.Movies;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;

public class AppTest {
    @Test
    public void genreTest() throws SQLException {


        GenreDao genre = new GenreDao();
        genre.find(4);
        genre.find("drama");
        Genres genres = new Genres();
        genres.printAllGenres();


    }

    @Test
    public void movieTest() throws SQLException {
        MovieDao movie = new MovieDao();
        movie.find(3);
        movie.find("The Godfather");
        movie.insert("Avengers: Endgame", Date.valueOf("2018-06-22"), 150, 8);
        movie.find(11);
        Movies movies = new Movies();
        movies.setMoviesData();
        movies.printAllMovies();
    }

    @Test
    public void imdbTest() {
        Imdb imdb = new Imdb(10);
        imdb.fileParser();
    }
}
