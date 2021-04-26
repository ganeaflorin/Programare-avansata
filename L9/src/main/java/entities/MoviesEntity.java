package entities;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "MOVIES", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "findByName", query = "SELECT m FROM MoviesEntity m WHERE m.title=:title"),
        @NamedQuery(name = "getAllMovies", query = "SELECT m FROM MoviesEntity m")
})
public class MoviesEntity implements Comparable<MoviesEntity> {
    private Long id;
    private String title;
    private Time releaseDate;
    private Long duration;
    private Long score;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "RELEASE_DATE")
    public Time getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Time releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "DURATION")
    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "SCORE")
    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesEntity that = (MoviesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(duration, that.duration) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, duration, score);
    }

    @Override
    public String toString() {
        return "MoviesEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(MoviesEntity movie) {
        return this.score.compareTo(movie.getScore());
    }
}
