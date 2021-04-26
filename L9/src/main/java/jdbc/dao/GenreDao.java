package jdbc.dao;

import jdbc.queries.SelectGenre;

import java.sql.SQLException;
import java.util.List;

public class GenreDao {
    SelectGenre select;

    public GenreDao() throws SQLException {
        this.select = new SelectGenre();
    }

    public void findById(int id) throws SQLException {
        System.out.println(select.genreIdQuery(id).toString());
    }

    public void findByName(String name) throws SQLException {
        System.out.println(select.genreNameQuery(name).toString());
    }

    public void create(String name) throws SQLException {
        if (select.genreNameQuery(name) != null)
            System.out.println("Genre " + name + " already exists.");
        else
            select.insert(name);
    }

    public List<Genre> getAllGenres() throws SQLException {
        return select.getAllGenres();
    }
}
