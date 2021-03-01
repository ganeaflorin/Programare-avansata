package comp;

public class Museum extends Location implements Payable, Visitable {
    /**
     * daca ora de deschidere e valida, o setam
     * daca suma de plata e pozitiva o setam
     * adaugam obiectul in lista
     * @param name numele care sa fie setat
     * @param openingHour ora de deschidere care sa fie setata
     * @param entryFee suma care trebuie platita
     */
    public Museum(String name, int openingHour, int entryFee) {
        if (!this.setOpeningHours(openingHour))
            System.out.println("Please insert an opening hour between 0-24.");
        if (!this.setEntryFee(entryFee))
            System.out.println("Please insert a positive entry fee.");
        this.name = name;
        City.addLocation(this);
    }

}
