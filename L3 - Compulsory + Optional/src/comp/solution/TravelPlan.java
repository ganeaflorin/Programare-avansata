package comp.solution;

import comp.locations.City;
import comp.locations.Location;

import java.util.List;

public class TravelPlan {
    private City city;
    private List<Location> preferences;

    public TravelPlan(City city, List<Location> preferences) {
        this.city = city;
        this.preferences = preferences;
    }
}
