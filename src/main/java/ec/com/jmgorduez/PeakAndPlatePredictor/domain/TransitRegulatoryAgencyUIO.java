package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ITransitRegulatoryAgency;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class TransitRegulatoryAgencyUIO implements ITransitRegulatoryAgency {

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
    public ILicensePlateNumber instanceLicensePlateNumber(String value) {
        Integer lastNumber = lastCharacter(value);
        return new LicensePlateNumberUIO(LicensePlateNumberTypeUIO.instance(lastNumber).get());
    }

    private int lastCharacter(String value) {
        return Character.getNumericValue(value.charAt(value.length() - ONE));
    }
}
