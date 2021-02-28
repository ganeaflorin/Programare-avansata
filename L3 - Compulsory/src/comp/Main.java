package comp;

public class Main {
    public static void main(String[] args) {
        Hotel v1 = new Hotel("Hotel", 4);
        Museum v2 = new Museum("Museum A", 8, 50);
        Museum v3 = new Museum("Museum B", 9, 60);
        Church v4 = new Church("Church A", 7);
        Church v5 = new Church("Church B", 8);
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
    }
}
