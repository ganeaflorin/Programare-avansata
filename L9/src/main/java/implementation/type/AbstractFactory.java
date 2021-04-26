package implementation.type;

import repository.AbstractRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public interface AbstractFactory {

    default String getType() throws IOException {
        FileReader fileReader = new FileReader("implementationType.txt");
        BufferedReader buff = new BufferedReader(fileReader);
        String type = buff.readLine();
        return type;
    }

    AbstractRepository createRepository() throws SQLException, IOException;
}
