package comp;

public class Hotel extends Location implements Classifiable {
    public Hotel(String name, int rank) {
        if (!this.setClassification(rank))
            System.out.println("Please insert rank between 0-5.");
        this.name = name;
        City.addLocation(this);
    }

}
