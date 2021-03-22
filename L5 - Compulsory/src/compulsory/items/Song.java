package compulsory.items;

import compulsory.YearException;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.Year;

public class Song extends Item implements Serializable {
    private String singer;
    private Year releaseYear;

    public Song(String name, String path, String singer, Year releaseYear) {
        this.name = name;
        this.path = path;
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

    public void setReleaseYear(int releaseYear) throws YearException {
        if (releaseYear < 0 || releaseYear > 2021) throw new YearException();
        this.releaseYear = Year.of(releaseYear);
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                "path='" + path + '\'' +
                "singer='" + singer + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
