package repository;


import entities.MoviesEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepository extends AbstractRepository<MoviesEntity> {


    public MovieRepository() {
        super();
    }

    public MoviesEntity findById(long id) {
        MoviesEntity movie = entityManager.find(MoviesEntity.class, id);
//        entityManager.getTransaction();
        return movie;
    }

    public List<MoviesEntity> findByName(String title) {
        List<MoviesEntity> movieList = (List<MoviesEntity>) entityManager.createNamedQuery("findByName")
                .setParameter("title", title)
                .getResultList();
        return movieList;
    }
}
