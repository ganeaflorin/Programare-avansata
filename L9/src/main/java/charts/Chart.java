package charts;

import entities.MoviesEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Chart {
    private String name;
    private LocalDateTime creationDate;
    private List<MoviesEntity> movieList;
    private static EntityManager entityManager;

    public Chart(String name, LocalDateTime creationDate) {
        entityManager = ManagerFactory.getManagerFactory().createEntityManager();
        this.name = name;
        this.creationDate = creationDate;
        populateMovieList();
//        Collections.sort(movieList);
    }

    public void populateMovieList() {
        movieList = (List<MoviesEntity>) entityManager.createNamedQuery("getAllMovies")
                .getResultList();
        Collections.sort(movieList, Collections.reverseOrder());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<MoviesEntity> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MoviesEntity> movieList) {
        this.movieList = movieList;
    }

    public void printMovieList() {
        for (MoviesEntity movie : movieList)
            System.out.println(movie);
    }

}
