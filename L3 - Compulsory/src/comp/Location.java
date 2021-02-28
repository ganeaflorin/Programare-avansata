package comp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    String name;
    int rank;
    int openingHour;
    int entryFee;
    Map<Location, Integer> map;

    public Location() {
        map = new HashMap<Location, Integer>();
    }

    void addLocationMap(Location location, int time) {
        this.map.put(location, time);
    }

    public String getName() {
        return this.name;
    }



    public boolean setOpeningHours(int hour) {
        if (hour < 0 || hour > 24)
            return false;
        this.openingHour = hour;
        return true;
    }

    public boolean setClassification(int rank) {
        if (rank < 0 || rank > 5)
            return false;
        this.rank = rank;
        return true;
    }

    public boolean setEntryFee(int entryFee) {
        if (entryFee < 0)
            return false;
        this.entryFee = entryFee;
        return true;
    }

    public String toString() {
        return "Location name: " + name;
    }
}
