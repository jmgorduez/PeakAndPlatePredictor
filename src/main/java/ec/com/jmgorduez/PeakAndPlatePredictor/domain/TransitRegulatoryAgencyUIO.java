package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ITransitRegulatoryAgency;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;

public class TransitRegulatoryAgencyUIO implements ITransitRegulatoryAgency {
    @Override
    public Boolean isAPeakAndPlateDate(LocalDate date) {
        return null;
    }

    @Override
    public Boolean isAPeakAndPlateTime(LocalTime time) {
        return time.isAfter(_06_59) && time.isBefore(_09_31)
                || time.isAfter(_15_59) && time.isBefore(_19_31);
    }

    @Override
    public ILicensePlateNumber instanceLicensePlateNumber(String value) {
        Integer lastNumber = lastCharacter(value);
        switch (lastNumber) {
            case 0:
            case 1:
                return new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS);
            case 2:
            case 3:
                return new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_TUESDAYS);
            case 4:
            case 5:
                return new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_WEDNESDAYS);
            case 6:
            case 7:
                return new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_THURSDAYS);
            default:
                return new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_FRIDAYS);
        }
    }

    private int lastCharacter(String value) {
        return Character.getNumericValue(value.charAt(value.length() - ONE));
    }
}
