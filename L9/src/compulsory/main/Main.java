package compulsory.main;

import compulsory.dao.*;
import compulsory.imdb.dataset.Imdb;
import compulsory.object.oriented.Genres;
import compulsory.object.oriented.Movies;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab9");
        Movie movie = new Movie();
        movie.setId(99);
        movie.setTitle("entityTest");
        movie.setScore(10);
        movie.setDuration(100);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
