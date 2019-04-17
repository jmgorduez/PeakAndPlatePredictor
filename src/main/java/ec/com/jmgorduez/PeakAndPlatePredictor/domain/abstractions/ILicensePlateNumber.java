package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface ILicensePlateNumber {
    PeakAndPlateStatus peakAndPlateStatusAt(LocalTime time,
                                            Function<LocalDate, Boolean> isAPeakAndPlateDay,
                                            Function<LocalTime, Boolean> isAPeakAndPlateTime);
}
