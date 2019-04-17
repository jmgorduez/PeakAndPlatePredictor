package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Function;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static java.time.DayOfWeek.*;

public class LicensePlateNumberUIO implements ILicensePlateNumber {

    public enum LicensePlateNumberClassifier{
        LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS(MONDAY),
        LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_TUESDAYS(TUESDAY),
        LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_WEDNESDAYS(WEDNESDAY),
        LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_THURSDAYS(THURSDAY),
        LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_FRIDAYS(FRIDAY);

        private final DayOfWeek dayOfWeekCanBeNotOnRoad;

        LicensePlateNumberClassifier(DayOfWeek dayOfWeekCanBeNotOnRoad){
            this.dayOfWeekCanBeNotOnRoad = dayOfWeekCanBeNotOnRoad;
        }

        public boolean canBeOnRoadAt(DayOfWeek dayOfWeek){
            return !this.dayOfWeekCanBeNotOnRoad.equals(dayOfWeek);
        }
    }

    private final LicensePlateNumberClassifier licensePlateNumberClassifier;

    public LicensePlateNumberUIO(LicensePlateNumberClassifier licensePlateNumberClassifier) {
        this.licensePlateNumberClassifier = licensePlateNumberClassifier;
    }

    @Override
    public PeakAndPlateStatus peakAndPlateStatusAt(LocalDate date,
                                                   LocalTime time,
                                                   Function<LocalDate, Boolean> isAPeakAndPlateDate,
                                                   Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        if(isNotAPeakAndPlateTime(time, isAPeakAndPlateTime)){
            return CAN_BE_ON_THE_ROAD;
        }
        if(isNotAPeakAndPlateDate(date, isAPeakAndPlateDate)){
            return CAN_BE_ON_THE_ROAD;
        }
        return licensePlateNumberClassifier.canBeOnRoadAt(date.getDayOfWeek())
                ? CAN_BE_ON_THE_ROAD : CAN_BE_NOT_ON_THE_ROAD;
    }

    private boolean isNotAPeakAndPlateDate(LocalDate date, Function<LocalDate, Boolean> isAPeakAndPlateDate) {
        return !isAPeakAndPlateDate.apply(date);
    }

    private boolean isNotAPeakAndPlateTime(LocalTime time, Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        return !isAPeakAndPlateTime.apply(time);
    }
}
