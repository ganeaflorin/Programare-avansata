package compulsory.imdb.dataset;

import compulsory.dao.Genre;
import compulsory.dao.Movie;
import compulsory.person.Actor;
import compulsory.person.Director;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Imdb {
    private final String path = "C:\\Users\\andre\\Downloads\\movies.csv";
    private List<Movie> movieList = new ArrayList<>();

    public void fileParser() {
        String line = "";
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (count < 10 && (line = br.readLine()) != null) {
                if (count > 0) {
                    Movie movie = csvToMovie(line);
                    movieList.add(movie);
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Movie csvToMovie(String line) throws ParseException {
        String[] values = line.split(",");
        String title = values[1].replaceAll("\\|", ",");
        int duration = Integer.parseInt(values[6]);
        int score = (int) Math.ceil(Double.parseDouble(values[14]));
        //hardcodam releaseDate adaugand la release year -01-01
        String releaseDate = values[3] + "-01-01";
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse(releaseDate);


        Movie movie = new Movie(title, date, duration, score);
        movie.setGenresList(csvGenres(values[5]));
        movie.setDirectorsList(csvDirectors(values[9]));
        movie.setActorsList(csvActors(values[12]));
        System.out.println(movie);

        return movie;
    }

    private List<Genre> csvGenres(String values) {
        List<Genre> movieGenres = new ArrayList<>();
        String[] genres = values.split("\\|");
        for (String genre : genres) {
            movieGenres.add(new Genre(genre));
        }
        return movieGenres;
    }

    private List<Director> csvDirectors(String values) {
        List<Director> movieDirectors = new ArrayList<>();
        String[] directors = values.split("\\|");
        for (String director : directors)
            movieDirectors.add(new Director(director, -1));
        return movieDirectors;
    }

    private List<Actor> csvActors(String values) {
        List<Actor> movieActors = new ArrayList<>();
        String[] actors = values.split("\\|");
        for (String actor : actors)
            movieActors.add(new Actor(actor, -1));
        return movieActors;
    }
}
