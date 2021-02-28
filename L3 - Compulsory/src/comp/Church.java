package comp;

public class Church extends Location implements Visitable {
    public Church(String name, int openingHour) {
        if (!this.setOpeningHours(openingHour))
            System.out.println("Please insert an opening hour between 0-24.");
        this.name = name;
        City.addLocation(this);
    }


}
