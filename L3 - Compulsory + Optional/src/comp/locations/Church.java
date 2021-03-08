package comp.locations;

import comp.interfaces.Visitable;

import java.time.LocalTime;

public class Church extends Location implements Visitable {
    private LocalTime openingHour, closingHour;

    public Church(String name, LocalTime openingHour, LocalTime closingHour) {
        this.name = name;
        this.closingHour = closingHour;
        this.openingHour = openingHour;
        City.addLocation(this);
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    @Override
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return closingHour;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + " opening hour: " + this.getOpeningHour();
    }


}



