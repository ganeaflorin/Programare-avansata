package comp;

public class Museum extends Location implements Payable, Visitable {
    public Museum(String name, int openingHour, int entryFee) {
        if (!this.setOpeningHours(openingHour))
            System.out.println("Please insert an opening hour between 0-24.");
        if (!this.setEntryFee(entryFee))
            System.out.println("Please insert a positive entry fee.");
        this.name = name;
        City.addLocation(this);
    }

}
