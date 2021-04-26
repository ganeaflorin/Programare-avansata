package implementation.type;

import repository.AbstractRepository;
import repository.MovieDao;
import repository.MovieRepository;

import java.io.IOException;
import java.sql.SQLException;

public class MovieFactory implements AbstractFactory {

    @Override
    public AbstractRepository createRepository() throws SQLException, IOException {
        if (getType().equals("jdbc"))
            return new MovieDao();
        if (getType().equals("jpa"))
            return new MovieRepository();
        return null;
    }
}
