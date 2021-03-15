package compulsory.items;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.Year;

public class Song extends Item implements Serializable{
    private String singer;
    private Year releaseYear;

    public Song(String name, Path path, String singer, Year releaseYear) {
        super(name, path);
        this.singer = singer;
        this.releaseYear = releaseYear;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Song{" +
                "singer='" + singer + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
