package manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactory {
    private static EntityManagerFactory factory;

    private ManagerFactory() {
        factory = Persistence.createEntityManagerFactory("Laborator");
    }

    public static EntityManagerFactory getManagerFactory() {
        if (factory == null)
            new ManagerFactory();
        return factory;
    }
}
