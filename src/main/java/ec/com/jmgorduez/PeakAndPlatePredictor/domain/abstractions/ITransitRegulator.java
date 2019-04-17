package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public interface ITransitRegulator {
    Boolean isAPeakAndPlateDayOfWeek(DayOfWeek dayOfWeek);
    Boolean isAPeakAndPlateTime(LocalTime time);
}
