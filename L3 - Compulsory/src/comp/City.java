package comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class City {
    /**
     * @param locations lista cu locatiile
     */
    public static List<Location> locations = new ArrayList<Location>();
    String name;

    /**
     * adauga un obiect in lista locations
     *
     * @param obj obiectul care sa fie adaugat
     */
    public static void addLocation(Location obj) {
        locations.add(obj);
    }

    /**
     * @return lista locations
     */
    public List getList() {
        return locations;
    }

    /**
     * constructor pentru City
     *
     * @param name numele care sa fie setat
     */
    public City(String name) {
        this.name = name;
    }

    /**
     * afiseaza obiectele din lista locations
     */
    public void printLocations() {
        for (Object i : locations) {
            System.out.println(i.toString());
        }
    }

    /**
     * parcurgem lista cu locatii
     * pentru fiecare locatie afisam mapa cu locatiile in care se poate ajunge si cat timp dureaza
     */
    public void printMaps() {

        for (int i = 0; i < locations.size(); i++) {
            Location tempLocation = locations.get(i);
            for (Map.Entry<Location, Integer> entry : tempLocation.map.entrySet()) {
                System.out.println(tempLocation.getName() + "<->" + entry.getKey().getName() + " " + entry.getValue());

            }
        }
    }
}
