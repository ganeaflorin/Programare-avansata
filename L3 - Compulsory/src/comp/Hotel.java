package comp;

public class Hotel extends Location implements Classifiable {
    /**
     * daca rankul e valid, il setam, altfel afisam un mesaj de avertizare
     * adaugam obiectul in array
     * @param name numele cu care sa fie creat obiectul
     * @param rank ratingul care sa fie setat
     */
    public Hotel(String name, int rank) {
        if (!this.setClassification(rank))
            System.out.println("Please insert rank between 0-5.");
        this.name = name;
        City.addLocation(this);
    }

}
