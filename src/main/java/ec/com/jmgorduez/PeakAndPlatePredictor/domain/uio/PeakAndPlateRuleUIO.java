package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.INonWorkingDateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.*;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants._19_31;

public class PeakAndPlateRuleUIO implements IPeakAndPlateRule {

    private final TypePeakAndPlateRuleUIO typePeakAndPlateRuleUIO;
    private final INonWorkingDateChecker localDateChecker;

    public PeakAndPlateRuleUIO(TypePeakAndPlateRuleUIO typePeakAndPlateRuleUIO,
                               INonWorkingDateChecker localDateChecker) {
        this.typePeakAndPlateRuleUIO = typePeakAndPlateRuleUIO;
        this.localDateChecker = localDateChecker;
    }

    @Override
    public Boolean isAPeakAndPlateDate(LocalDate date) {
        return localDateChecker.isNotAWeekendDay(date) &&
                localDateChecker.isNotAHoliday(date);
    }

    @Override
    public Boolean isAPeakAndPlateTime(LocalTime time) {
        return time.isAfter(_06_59) && time.isBefore(_09_31)
                || time.isAfter(_15_59) && time.isBefore(_19_31);
    }

    @Override
    public PeakAndPlateStatus peakAndPlateStatusAt(LocalDate date, LocalTime time) {
        if (isNotAPeakAndPlateTime(time)) {
            return ON_THE_ROAD;
        }
        if (isNotAPeakAndPlateDate(date)) {
            return ON_THE_ROAD;
        }
        return typePeakAndPlateRuleUIO.canBeOnRoadAt(date.getDayOfWeek())
                ? ON_THE_ROAD : NOT_ON_THE_ROAD;
    }

    private boolean isNotAPeakAndPlateDate(LocalDate date) {
        return !isAPeakAndPlateDate(date);
    }

    private boolean isNotAPeakAndPlateTime(LocalTime time) {
        return !isAPeakAndPlateTime(time);
    }
}
