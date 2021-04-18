package compulsory.dao;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;

public class AppTest {
    @Test
    public void mainTest() throws SQLException {
        MovieDao movie = new MovieDao();
        movie.find(3);
        movie.find("The Godfather");
        movie.insert("Test", Date.valueOf("2018-06-22"), 120, 8);
        movie.find(13);
        GenreDao genre = new GenreDao();
        genre.find(4);
        genre.find("drama");
        genre.insert("crime");

    }
}
