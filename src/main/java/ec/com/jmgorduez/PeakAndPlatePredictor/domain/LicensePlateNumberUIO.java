package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Function;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;

public class LicensePlateNumberUIO implements ILicensePlateNumber {

    private final LicensePlateNumberTypeUIO licensePlateNumberTypeUIO;

    public LicensePlateNumberUIO(LicensePlateNumberTypeUIO licensePlateNumberTypeUIO) {
        this.licensePlateNumberTypeUIO = licensePlateNumberTypeUIO;
    }

    @Override
    public PeakAndPlateStatus peakAndPlateStatusAt(LocalDate date, LocalTime time,
                                                   Function<LocalDate, Boolean> isAPeakAndPlateDate,
                                                   Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        if (isNotAPeakAndPlateTime(time, isAPeakAndPlateTime)) {
            return CAN_BE_ON_THE_ROAD;
        }
        if (isNotAPeakAndPlateDate(date, isAPeakAndPlateDate)) {
            return CAN_BE_ON_THE_ROAD;
        }
        return licensePlateNumberTypeUIO.canBeOnRoadAt(date.getDayOfWeek())
                ? CAN_BE_ON_THE_ROAD : CAN_BE_NOT_ON_THE_ROAD;
    }

    private boolean isNotAPeakAndPlateDate(LocalDate date, Function<LocalDate, Boolean> isAPeakAndPlateDate) {
        return !isAPeakAndPlateDate.apply(date);
    }

    private boolean isNotAPeakAndPlateTime(LocalTime time, Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        return !isAPeakAndPlateTime.apply(time);
    }

    @Override
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }
        if (!(other instanceof LicensePlateNumberUIO)) {
            return false;
        }
        return this.licensePlateNumberTypeUIO
                .equals(((LicensePlateNumberUIO)other).licensePlateNumberTypeUIO);
    }
}
