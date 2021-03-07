package comp.locations;

import comp.interfaces.Classifiable;

public class Restaurant extends Location implements Classifiable {
    private int rank;

    public Restaurant(String name, int rank) {
        if (!this.setClassification(rank))
            System.out.println("Please insert rank between 0-5.");
        this.name = name;
        City.addLocation(this);
    }

    public boolean setClassification(int rank) {
        if (rank < 0 || rank > 5)
            return false;
        this.rank = rank;
        return true;
    }
}
