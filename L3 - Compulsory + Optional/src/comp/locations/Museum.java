package comp.locations;

import comp.interfaces.Payable;
import comp.interfaces.Visitable;

import java.time.LocalTime;

public class Museum extends Location implements Payable, Visitable {
    private LocalTime openingHour, closingHour;
    double entryFee;

    public Museum(String name, LocalTime openingHour, LocalTime closingHour) {
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

    public double getEntryFee() {
        return entryFee;
    }

    public boolean setEntryFee(double entryFee) {
        if (entryFee < 0)
            return false;
        this.entryFee = entryFee;
        return true;
    }
}
