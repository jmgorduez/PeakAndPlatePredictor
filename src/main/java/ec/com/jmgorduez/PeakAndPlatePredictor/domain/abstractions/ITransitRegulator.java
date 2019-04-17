package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ITransitRegulator {
    Boolean isAPeakAndPlateDayOfWeek(LocalDate date);
    Boolean isAPeakAndPlateTime(LocalTime time);
    ILicensePlateNumber instanceLicensePlateNumber(String value);
}
