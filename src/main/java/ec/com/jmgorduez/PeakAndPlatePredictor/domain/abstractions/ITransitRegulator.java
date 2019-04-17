package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public interface ITransitRegulator {
    Boolean isAPeakAndPlateDayOfWeek(LocalDate date);
    Boolean isAPeakAndPlateTime(LocalTime time);
    ILicensePlateNumber licensePlateNumberOn(String value, LocalDate date);
}
