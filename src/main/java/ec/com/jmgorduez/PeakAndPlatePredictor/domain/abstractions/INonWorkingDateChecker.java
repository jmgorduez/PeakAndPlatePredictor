package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.time.LocalDate;

public interface INonWorkingDateChecker {
    Boolean isNotAHoliday(LocalDate date);
    Boolean isNotAWeekendDay(LocalDate date);
}
