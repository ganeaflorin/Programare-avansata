package compulsory.dao;

import compulsory.person.Actor;
import compulsory.person.Director;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
    private Integer id;
    private String title;
    private Date date;
    private Integer duration;
    private Integer score;
    private List<Actor> actorsList = new ArrayList<>();
    private List<Director> directorsList = new ArrayList<>();
    private List<Genre> genresList = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, Date date, Integer duration, Integer score) {
        this.title = title;
        this.date = date;
        this.setDuration(duration);
        this.setScore(score);
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration < 0)
            throw new IllegalArgumentException("Duration must be positive.");
        this.duration = duration;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(int score) {

        if (score < 0 || score > 10)
            throw new IllegalArgumentException("Score input must be between 0 and 10: " + score);
        this.score = score;
    }

    public void setActorsList(List<Actor> actorsList) {
        this.actorsList = actorsList;
    }

    public void setDirectorsList(List<Director> directorsList) {
        this.directorsList = directorsList;
    }

    public void setGenresList(List<Genre> genresList) {
        this.genresList = genresList;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title=" + title +
                ", release date=" + date +
                ", duration=" + duration + " min" +
                ", score=" + score + "/10" +
                "\nGenres: " + genresList +
                "\nActor(s): " + actorsList.toString() +
                "\nDirector(s)" + directorsList.toString() + "\n";
    }
}
