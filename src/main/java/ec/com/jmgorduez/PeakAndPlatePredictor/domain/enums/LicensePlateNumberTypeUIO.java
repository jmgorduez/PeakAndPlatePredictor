package ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums;

import java.time.DayOfWeek;

import static java.time.DayOfWeek.*;

public enum LicensePlateNumberTypeUIO {
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS(MONDAY),
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_TUESDAYS(TUESDAY),
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_WEDNESDAYS(WEDNESDAY),
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_THURSDAYS(THURSDAY),
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_FRIDAYS(FRIDAY);

    private final DayOfWeek dayOfWeekCanBeNotOnRoad;

    LicensePlateNumberTypeUIO(DayOfWeek dayOfWeekCanBeNotOnRoad) {
        this.dayOfWeekCanBeNotOnRoad = dayOfWeekCanBeNotOnRoad;
    }

    public boolean canBeOnRoadAt(DayOfWeek dayOfWeek) {
        return !this.dayOfWeekCanBeNotOnRoad.equals(dayOfWeek);
    }
}