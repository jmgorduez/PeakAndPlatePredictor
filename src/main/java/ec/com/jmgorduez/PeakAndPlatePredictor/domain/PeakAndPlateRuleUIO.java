package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.TypePeakAndPlateRuleUIO;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.*;
import java.util.List;
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
        return !holidays(Year.from(date)).contains(date);
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

    private static List<LocalDate> holidays(Year year) {
        return HOLIDAYS_UIO.stream()
                .map(monthDay -> monthDay.atYear(year.getValue()))
                .map(date -> adjustHolidayDateAccordingLaw(date))
                .collect(Collectors.toList());
    }

    private static LocalDate adjustHolidayDateAccordingLaw(LocalDate date) {
        if (isNotSwitchableHoliday(date) || isNotNecessaryToSwitchDate(date)) {
            return date;
        }
        if (isNecessaryToSwitchOneDayBefore(date)) {
            return date.minusDays(ONE);
        }
        if (isNecessaryToSwitchOneDayAfter(date)) {
            return date.plusDays(ONE);
        }
        return date.plusDays(numbersOfDaysUntilFriday(date));
    }

    private static int numbersOfDaysUntilFriday(LocalDate date) {
        return FRIDAY.getValue() - date.getDayOfWeek().getValue();
    }

    private static boolean isNecessaryToSwitchOneDayAfter(LocalDate date) {
        return SUNDAY.equals(date.getDayOfWeek());
    }

    private static boolean isNecessaryToSwitchOneDayBefore(LocalDate date) {
        return TUESDAY.equals(date.getDayOfWeek()) || SATURDAY.equals(date.getDayOfWeek());
    }

    private static boolean isNotNecessaryToSwitchDate(LocalDate dateOfYear) {
        return dateOfYear.getDayOfWeek().equals(MONDAY) || dateOfYear.getDayOfWeek().equals(FRIDAY);
    }

    private static boolean isNotSwitchableHoliday(LocalDate date) {
        return MonthDay.from(date).equals(JANUARY_01) || MonthDay.from(date).equals(DECEMBER_25);
    }
}
