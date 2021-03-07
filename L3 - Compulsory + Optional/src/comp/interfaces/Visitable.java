package comp.interfaces;

import comp.locations.Location;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningHour();

    LocalTime getClosingHour();

    void setOpeningHour(LocalTime time);

    void setClosingHour(LocalTime time);

    default void setDefaultHours() {
        setOpeningHour(LocalTime.of(9, 30));
        setClosingHour(LocalTime.of(21, 0));
    }

    static Duration getVisitingDuration(Location location) {
        return Duration.between(location.getClosingHour(), location.getOpeningHour());

    }
}
