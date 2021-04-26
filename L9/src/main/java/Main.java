import repository.MovieRepository;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Laborator");
//        Movie movie = new Movie();
//        movie.setId(22);
//        movie.setTitle("test");
//        System.out.println(movie);
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(movie);
//        entityManager.getTransaction().commit();
//        entityManagerFactory.close();
        MovieRepository repo = new MovieRepository();
        System.out.println(repo.findById(1));

//        Movie movie = new Movie();
//        movie.setId(41);
//        movie.setTitle("test");
//        repo.create(movie);
        System.out.println(repo.findByName("Edge of Tomorrow"));
    }
}
