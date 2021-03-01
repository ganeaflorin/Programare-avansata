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

    /**
     * constructor pentru Location
     * instantiem mapa pentru fiecare locatie
     */
    public Location() {
        map = new HashMap<Location, Integer>();
    }

    /**
     * adauga in mapa locatiei o locatie la care se poate ajunge si timpul necesar
     *
     * @param location locatia care sa fie adaugata in mapa
     * @param time     timpul dintr-o locatie in alta
     */
    void addLocationMap(Location location, int time) {
        this.map.put(location, time);
    }

    /**
     * @return numele obiectului
     */
    public String getName() {
        return this.name;
    }

    /**
     * verifica daca ora este intre 0 si 24 si o seteaza daca respecta conditia
     *
     * @param hour ora de deschidere care sa fie setata
     * @return true daca s-a reusit setarea orei, false in caz contrar
     */
    public boolean setOpeningHours(int hour) {
        if (hour < 0 || hour > 24)
            return false;
        this.openingHour = hour;
        return true;
    }

    /**
     * verifica daca rankul este intre 0 si 5 si il seteaza daca respecta conditia
     *
     * @param rank rankul care sa fie setat
     * @return true daca s-a reusit setarea rankului, false in caz contrar
     */
    public boolean setClassification(int rank) {
        if (rank < 0 || rank > 5)
            return false;
        this.rank = rank;
        return true;
    }

    /**
     * verifica daca suma de plata este pozitiva si o seteaza daca respecta conditia
     *
     * @param entryFee plata care trebuie setata
     * @return true daca s-a reusit setarea sumei de plata, false in caz contrar
     */
    public boolean setEntryFee(int entryFee) {
        if (entryFee < 0)
            return false;
        this.entryFee = entryFee;
        return true;
    }

    /**
     * @return numele obiectului
     */
    public String toString() {
        return "Location name: " + name;
    }
}
