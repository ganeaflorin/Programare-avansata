package comp.locations;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location> {
    protected String name;
    protected Map<Location, Integer> map;

    public Location() {
        map = new HashMap<>();
    }

    public LocalTime getOpeningHour() {
        return LocalTime.of(0, 0);
    }

    public LocalTime getClosingHour() {
        return LocalTime.of(0, 0);
    }

    public void addLocationMap(Location location, int time) {
        this.map.put(location, time);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Location other) {
        return this.getOpeningHour().compareTo(other.getOpeningHour());
    }

    public String toString() {
        return "Location name: " + name;
    }
}
