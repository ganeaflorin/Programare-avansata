package compulsory.object.oriented;

import compulsory.dao.Genre;
import compulsory.dao.GenreDao;

import java.sql.SQLException;
import java.util.List;

public class Genres {
    private List<Genre> genres;
    private GenreDao genreDao;

    public Genres() throws SQLException {
        genreDao = new GenreDao();
        genres = genreDao.getAllGenres();
    }

    public void printAllGenres() {
        for (Genre genre : genres)
            System.out.println(genre);
    }
}
