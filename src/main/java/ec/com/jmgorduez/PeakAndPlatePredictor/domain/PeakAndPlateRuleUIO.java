package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants._19_31;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class PeakAndPlateRuleUIO implements IPeakAndPlateRule {

    private final LicensePlateNumberTypeUIO licensePlateNumberTypeUIO;

    public PeakAndPlateRuleUIO(LicensePlateNumberTypeUIO licensePlateNumberTypeUIO) {
        this.licensePlateNumberTypeUIO = licensePlateNumberTypeUIO;
    }

    @Override
    public Boolean isAPeakAndPlateDate(LocalDate date) {
        return isNotAWeekendDay(date);
    }

    private boolean isNotAWeekendDay(LocalDate date) {
        return !(SATURDAY.equals(date.getDayOfWeek()) || SUNDAY.equals(date.getDayOfWeek()));
    }

    @Override
    public Boolean isAPeakAndPlateTime(LocalTime time) {
        return time.isAfter(_06_59) && time.isBefore(_09_31)
                || time.isAfter(_15_59) && time.isBefore(_19_31);
    }

    @Override
    public PeakAndPlateStatus peakAndPlateStatusAt(LocalDate date, LocalTime time) {
        if (isNotAPeakAndPlateTime(time)) {
            return CAN_BE_ON_THE_ROAD;
        }
        if (isNotAPeakAndPlateDate(date)) {
            return CAN_BE_ON_THE_ROAD;
        }
        return licensePlateNumberTypeUIO.canBeOnRoadAt(date.getDayOfWeek())
                ? CAN_BE_ON_THE_ROAD : CAN_BE_NOT_ON_THE_ROAD;
    }

    private boolean isNotAPeakAndPlateDate(LocalDate date) {
        return !isAPeakAndPlateDate(date);
    }

    private boolean isNotAPeakAndPlateTime(LocalTime time) {
        return !isAPeakAndPlateTime(time);
    }

    @Override
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }
        if (!(other instanceof PeakAndPlateRuleUIO)) {
            return false;
        }
        return this.licensePlateNumberTypeUIO
                .equals(((PeakAndPlateRuleUIO)other).licensePlateNumberTypeUIO);
    }
}
