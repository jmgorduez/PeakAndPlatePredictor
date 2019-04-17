package ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static java.time.DayOfWeek.*;

public enum LicensePlateNumberTypeUIO {
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS(MONDAY, ZERO, ONE),
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_TUESDAYS(TUESDAY, TWO, THREE),
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_WEDNESDAYS(WEDNESDAY, FOUR, FIVE),
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_THURSDAYS(THURSDAY, SIX, SEVEN),
    LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_FRIDAYS(FRIDAY, EIGHT, NINE);

    private final DayOfWeek dayOfWeekCanBeNotOnRoad;
    private final List<Integer> lastNumbersCanBeNotOnRoad;

    LicensePlateNumberTypeUIO(DayOfWeek dayOfWeekCanBeNotOnRoad, Integer... lastNumbersCanBeNotOnRoad) {
        this.dayOfWeekCanBeNotOnRoad = dayOfWeekCanBeNotOnRoad;
        this.lastNumbersCanBeNotOnRoad
                = Arrays.stream(lastNumbersCanBeNotOnRoad).collect(Collectors.toList());
    }

    public boolean canBeOnRoadAt(DayOfWeek dayOfWeek) {
        return !this.dayOfWeekCanBeNotOnRoad.equals(dayOfWeek);
    }

    public static Optional<LicensePlateNumberTypeUIO> instance(Integer lastNumber) {
        return Arrays.stream(values())
                .filter(itRepresentsToThisLastNumber(lastNumber))
                .reduce(selectUniqueElement());
    }

    private static BinaryOperator<LicensePlateNumberTypeUIO> selectUniqueElement() {
        return (licensePlateNumberTypeUIO, licensePlateNumberTypeUIO2) -> licensePlateNumberTypeUIO;
    }

    private static Predicate<LicensePlateNumberTypeUIO> itRepresentsToThisLastNumber(Integer lastNumberCanBeNotOnRoad) {
        return licensePlateNumberTypeUIO ->
                licensePlateNumberTypeUIO.lastNumbersCanBeNotOnRoad.contains(lastNumberCanBeNotOnRoad);
    }
}