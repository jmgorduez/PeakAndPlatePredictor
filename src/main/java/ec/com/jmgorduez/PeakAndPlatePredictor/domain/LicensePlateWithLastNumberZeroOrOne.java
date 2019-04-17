package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Function;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;

public class LicensePlateWithLastNumberZeroOrOne implements ILicensePlateNumber {

    @Override
    public PeakAndPlateStatus peakAndPlateStatusAt(LocalDate date,
                                                   LocalTime time,
                                                   Function<LocalDate, Boolean> isAPeakAndPlateDate,
                                                   Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        if(isNotAPeakAndPlateTime(time, isAPeakAndPlateTime)){
            return CAN_BE_ON_THE_ROAD;
        }
        if(isNotAPeakAndPlateDate(date, isAPeakAndPlateDate)){
            return CAN_BE_ON_THE_ROAD;
        }
        return isMonday(date) ? CAN_BE_NOT_ON_THE_ROAD : CAN_BE_ON_THE_ROAD;
    }

    private boolean isMonday(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    private boolean isNotAPeakAndPlateDate(LocalDate date, Function<LocalDate, Boolean> isAPeakAndPlateDate) {
        return !isAPeakAndPlateDate.apply(date);
    }

    private boolean isNotAPeakAndPlateTime(LocalTime time, Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        return !isAPeakAndPlateTime.apply(time);
    }
}
