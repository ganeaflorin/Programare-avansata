package comp.locations;

import comp.interfaces.Payable;
import comp.interfaces.Visitable;

import java.util.*;

public class City {

    public static List<Location> locations = new ArrayList<>();
    private String name;

    public static void addLocation(Location location) {
        locations.add(location);
    }

    public List getList() {
        return locations;
    }

    public City(String name) {
        this.name = name;
    }

    public void printLocations() {
        for (Location location : locations) {
            System.out.println(location.toString());
        }
    }

    /**
     * parcurgem lista cu locatii
     * pentru fiecare locatie afisam mapa cu locatiile in care se poate ajunge si cat timp dureaza
     */
    public void printMaps() {

        for (Location tempLocation : locations)
            for (Map.Entry<Location, Integer> entry : tempLocation.map.entrySet()) {
                System.out.println(tempLocation.getName() + "<->" + entry.getKey().getName() + " " + entry.getValue());

            }
    }

    public void printVisitableNotPayable() {
        List<Location> tempLocations = new ArrayList<>();
        for (Location location : locations) {
            if (location instanceof Visitable && !(location instanceof Payable))
                tempLocations.add(location);
            Collections.sort(tempLocations, (a, b) -> a.compareTo(b));

        }
        System.out.println(tempLocations.toString());
    }

}

