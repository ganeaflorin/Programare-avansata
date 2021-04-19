package compulsory.main;

import compulsory.dao.*;
import compulsory.imdb.dataset.Imdb;
import compulsory.object.oriented.Genres;
import compulsory.object.oriented.Movies;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        MovieDao movie = new MovieDao();
        movie.find(3);
        movie.find("The Godfather");
        movie.insert("Avengers: Endgame", Date.valueOf("2018-06-22"), 150, 8);
        movie.find(11);

        GenreDao genre = new GenreDao();
        genre.find(4);
        genre.find("drama");
//        genre.insert("crime");
        Genres genres = new Genres();
        genres.printAllGenres();
        Movies movies = new Movies();
        movies.setMoviesData();
        movies.printAllMovies();
        Imdb imdb = new Imdb(10);
        imdb.fileParser();
    }
}
