package comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class City {
    public static List<Location> locations = new ArrayList<Location>();
    String name;

    public static void addLocation(Location obj) {
        locations.add(obj);
    }

    public List getList() {
        return locations;
    }

    public City(String name) {
        this.name = name;
    }

    public void printLocations() {
        for (Object i : locations) {
            System.out.println(i.toString());
        }
    }

    public void printMaps() {

        for (int i = 0; i < locations.size(); i++) {
            Location tempLocation = locations.get(i);
            for (Map.Entry<Location, Integer> entry : tempLocation.map.entrySet()) {
                System.out.println(tempLocation.getName() + "<->" + entry.getKey().getName() + " " + entry.getValue());

            }
        }
    }
}
