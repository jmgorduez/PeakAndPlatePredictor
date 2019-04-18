package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.TypePeakAndPlateRuleUIO;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants._19_31;
import static java.time.DayOfWeek.*;

public class PeakAndPlateRuleUIO implements IPeakAndPlateRule {

    private final TypePeakAndPlateRuleUIO typePeakAndPlateRuleUIO;

    public PeakAndPlateRuleUIO(TypePeakAndPlateRuleUIO typePeakAndPlateRuleUIO) {
        this.typePeakAndPlateRuleUIO = typePeakAndPlateRuleUIO;
    }

    @Override
    public Boolean isAPeakAndPlateDate(LocalDate date) {
        return isNotAWeekendDay(date) &&
                isNotAHoliday(date);
    }

    private boolean isNotAHoliday(LocalDate date) {
        return !holidays(Year.from(date)).contains(MonthDay.from(date));
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
        return typePeakAndPlateRuleUIO.canBeOnRoadAt(date.getDayOfWeek())
                ? CAN_BE_ON_THE_ROAD : CAN_BE_NOT_ON_THE_ROAD;
    }

    private boolean isNotAPeakAndPlateDate(LocalDate date) {
        return !isAPeakAndPlateDate(date);
    }

    private boolean isNotAPeakAndPlateTime(LocalTime time) {
        return !isAPeakAndPlateTime(time);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PeakAndPlateRuleUIO)) {
            return false;
        }
        return this.typePeakAndPlateRuleUIO
                .equals(((PeakAndPlateRuleUIO) other).typePeakAndPlateRuleUIO);
    }

    private static List<MonthDay> holidays(Year year) {
        return HOLIDAYS_UIO.stream().map(monthDay -> {
            if (isNotSwitchableHoliday(monthDay)) {
                return monthDay;
            }
            return null;
        }).collect(Collectors.toList());
    }

    private static boolean isNotSwitchableHoliday(MonthDay monthDay) {
        return monthDay.equals(JANUARY_01) || monthDay.equals(DECEMBER_25);
    }
}
