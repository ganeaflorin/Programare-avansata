package comp;

public class Restaurant extends Location implements Classifiable {
    /**
     * daca rankul e valid, il setam, atlfel afisam un mesaj de avertizare
     * adaugam locatia in lista
     * @param name numele care sa fie setat
     * @param rank rankul care sa fie setat
     */
    public Restaurant(String name, int rank) {
        if (!this.setClassification(rank))
            System.out.println("Please insert rank between 0-5.");
        this.name = name;
        City.addLocation(this);
    }
}
