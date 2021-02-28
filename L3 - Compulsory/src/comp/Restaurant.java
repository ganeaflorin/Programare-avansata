package comp;

public class Restaurant extends Location implements Classifiable {
    public Restaurant(String name, int rank) {
        if (!this.setClassification(rank))
            System.out.println("Please insert rank between 0-5.");
        this.name = name;
        City.addLocation(this);
    }
}
