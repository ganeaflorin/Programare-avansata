package compulsory.queries;

import compulsory.dao.Genre;
import compulsory.person.Actor;
import compulsory.person.Director;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinQueries extends Query {
    private SelectGenre genreGetter = new SelectGenre();
    private SelectActor actorGetter = new SelectActor();
    private SelectDirector directorGetter = new SelectDirector();

    public JoinQueries() throws SQLException {
    }

    public List<Genre> getMovieGenres(int id) throws SQLException {
        final String query = "SELECT * FROM MOVIE_GENRE WHERE MOVIE_ID = " + id;
        List<Genre> movieGenres = new ArrayList<>();
        queryResult = stmt.executeQuery(query);
        while (queryResult.next()) {
            int genreId = queryResult.getInt("genre_id");

            movieGenres.add(genreGetter.genreIdQuery(genreId));
        }
        return movieGenres;
    }

    public List<Actor> getMovieActors(int id) throws SQLException {
        final String query = "SELECT * FROM MOVIE_ACTORS WHERE MOVIE_ID = " + id;
        List<Actor> movieActors = new ArrayList<>();
        queryResult = stmt.executeQuery(query);
        while (queryResult.next()) {
            int actorId = queryResult.getInt("actor_id");
            movieActors.add(actorGetter.actorIdQuery(actorId));
        }
        return movieActors;
    }

    public List<Director> getMovieDirectors(int id) throws SQLException {
        final String query = "SELECT * FROM MOVIE_DIRECTORS WHERE MOVIE_ID = " + id;
        List<Director> movieDirectors = new ArrayList<>();
        queryResult = stmt.executeQuery(query);
        while (queryResult.next()) {
            int directorId = queryResult.getInt("director_id");
            movieDirectors.add(directorGetter.directorIdQuery(directorId));
        }
        return movieDirectors;
    }
}
