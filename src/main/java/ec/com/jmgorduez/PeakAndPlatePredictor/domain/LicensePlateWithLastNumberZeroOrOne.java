package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Function;

public class LicensePlateWithLastNumberZeroOrOne implements ILicensePlateNumber {

    public LicensePlateWithLastNumberZeroOrOne(String value){

    }

    @Override
    public PeakAndPlateStatus peakAndPlateStatusAt(LocalDate date,
                                                   LocalTime time,
                                                   Function<LocalDate, Boolean> isAPeakAndPlateDate,
                                                   Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        return null;
    }
}
