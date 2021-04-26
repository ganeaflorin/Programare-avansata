package repository;

import charts.Chart;
import entities.MoviesEntity;
import implementation.type.AbstractFactory;
import implementation.type.MovieFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

class TestApp {
    MovieRepository repo = new MovieRepository();

    @Test
    void findById() {
        System.out.println(repo.findById(2L));
    }

    @Test
    void findByName() {
        System.out.println(repo.findByName("The Godfather"));
    }

    @Test
    void create() {
        MoviesEntity movie = new MoviesEntity();
        movie.setId(150L);
        movie.setTitle("Test");
        repo.create(movie);
    }

    @Test
    void chart() {
        Chart chart = new Chart("Top", LocalDateTime.now());
        chart.printMovieList();
    }

    @Test
    void movieDao() throws SQLException {
        MovieDao movieDao = new MovieDao();
        movieDao.findById(5);

    }

    @Test
    void implementationType() throws SQLException, IOException {
        MovieFactory movies = new MovieFactory();
        AbstractRepository repo = movies.createRepository();
        System.out.println(repo.findById(3));
    }


    //TODO: INCHIDE CONEXIUNI ETC
    //TODO: add pe github
}