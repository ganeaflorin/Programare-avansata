package repository;

import entities.MoviesEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public abstract class AbstractRepository<T> {
    protected static EntityManager entityManager;

    public AbstractRepository() {
        entityManager = ManagerFactory.getManagerFactory().createEntityManager();
    }

    public void closeConn() {
        entityManager.close();
    }

    public void create(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        System.out.println("Created successfully.");
    }

    public abstract T findById(long id) throws SQLException;

}
