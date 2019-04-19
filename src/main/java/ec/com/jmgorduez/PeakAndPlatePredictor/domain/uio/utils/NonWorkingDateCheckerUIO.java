package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.utils;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils.INonWorkingDateChecker;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.DECEMBER_25;
import static java.time.DayOfWeek.*;
import static java.time.DayOfWeek.FRIDAY;

public class NonWorkingDateCheckerUIO implements INonWorkingDateChecker {
    @Override
    public Boolean isNotAHoliday(LocalDate date) {
        return !holidays(Year.from(date)).contains(date);
    }

    @Override
    public Boolean isNotAWeekendDay(LocalDate date) {
        return !(SATURDAY.equals(date.getDayOfWeek()) || SUNDAY.equals(date.getDayOfWeek()));
    }

    List<LocalDate> holidays(Year year){
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
