package comp;

public class Church extends Location implements Visitable {
    /**
     * daca ora de deschidere e valida, o setam, atlfel afisam un mesaj de avertizare
     * adaugam obiectul in array
     * @param name        numele cu care sa fie creat obiectul
     * @param openingHour ora de deschidere a locatiei
     */
    public Church(String name, int openingHour) {
        if (!this.setOpeningHours(openingHour))
            System.out.println("Please insert an opening hour between 0-24.");

        this.name = name;
        City.addLocation(this);
    }
}



