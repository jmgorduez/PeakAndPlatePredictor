package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILocalDateChecker;

import java.time.LocalDate;

public class LocalDateCheckerUIO implements ILocalDateChecker {
    @Override
    public Boolean isNotAHoliday(LocalDate date) {
        return null;
    }

    @Override
    public Boolean isNotAWeekendDay(LocalDate date) {
        return null;
    }
}
