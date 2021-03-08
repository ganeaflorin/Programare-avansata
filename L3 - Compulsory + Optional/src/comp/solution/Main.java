package comp.solution;

import comp.interfaces.Visitable;
import comp.locations.*;

import java.time.LocalTime;

/**
 * @author Ganea Florin 2A5
 */
public class Main {
    public static void main(String[] args) {
        Hotel v1 = new Hotel("Hotel", 4);
        Museum v2 = new Museum("Museum A", LocalTime.of(9, 30), LocalTime.of(21, 30));
        Museum v3 = new Museum("Museum B", LocalTime.of(9, 0), LocalTime.of(22, 0));
        Church v4 = new Church("Church A", LocalTime.of(7, 30), LocalTime.of(21, 30));
        Church v5 = new Church("Church B", LocalTime.of(8, 0), LocalTime.of(21, 0));
        Restaurant v6 = new Restaurant("Restaurant", 4);

        v1.addLocationMap(v2, 10);
        v1.addLocationMap(v3, 50);
        v2.addLocationMap(v3, 20);
        v2.addLocationMap(v4, 20);
        v2.addLocationMap(v5, 10);
        v3.addLocationMap(v4, 20);
        v4.addLocationMap(v5, 30);
        v4.addLocationMap(v6, 10);
        v5.addLocationMap(v6, 20);

        City oras = new City("Iasi");
//        oras.printLocations();
        oras.printMaps();
        oras.printVisitableNotPayable();

        //default+static methods
        Church v10 = new Church("Churchaa", LocalTime.of(8, 25), LocalTime.of(5, 5));
        v10.setDefaultHours();
        System.out.println(v10.getOpeningHour() + "  " + v10.getClosingHour());
        System.out.println(Visitable.getVisitingDuration(v10));
    }
}
