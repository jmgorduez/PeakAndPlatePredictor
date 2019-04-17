package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ILicensePlateNumber {
    PeakAndPlateStatus peakAndPlateStatusAt(LocalDate date, LocalTime time);
}
