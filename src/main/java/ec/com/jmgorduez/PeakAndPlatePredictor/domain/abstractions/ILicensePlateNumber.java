package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Function;

public interface ILicensePlateNumber {
    PeakAndPlateStatus peakAndPlateStatusAt(LocalDate date,
                                            LocalTime time,
                                            Function<LocalDate, Boolean> isAPeakAndPlateDate,
                                            Function<LocalTime, Boolean> isAPeakAndPlateTime);
}
