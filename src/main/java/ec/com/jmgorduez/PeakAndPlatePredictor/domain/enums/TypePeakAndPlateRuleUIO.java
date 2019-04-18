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

public enum TypePeakAndPlateRuleUIO {
    CAN_BE_NOT_ON_ROAD_ON_MONDAYS(MONDAY, ZERO, ONE),
    CAN_BE_NOT_ON_ROAD_ON_TUESDAYS(TUESDAY, TWO, THREE),
    CAN_BE_NOT_ON_ROAD_ON_WEDNESDAYS(WEDNESDAY, FOUR, FIVE),
    CAN_BE_NOT_ON_ROAD_ON_THURSDAYS(THURSDAY, SIX, SEVEN),
    CAN_BE_NOT_ON_ROAD_ON_FRIDAYS(FRIDAY, EIGHT, NINE);

    private final DayOfWeek dayOfWeekCanBeNotOnRoad;
    private final List<Integer> lastNumbers;

    TypePeakAndPlateRuleUIO(DayOfWeek dayOfWeekCanBeNotOnRoad, Integer... lastNumbers) {
        this.dayOfWeekCanBeNotOnRoad = dayOfWeekCanBeNotOnRoad;
        this.lastNumbers
                = Arrays.stream(lastNumbers).collect(Collectors.toList());
    }

    public boolean canBeOnRoadAt(DayOfWeek dayOfWeek) {
        return !this.dayOfWeekCanBeNotOnRoad.equals(dayOfWeek);
    }

    public static Optional<TypePeakAndPlateRuleUIO> instance(Integer lastNumber) {
        return Arrays.stream(values())
                .filter(itRepresentsThisLastNumber(lastNumber))
                .reduce(selectUniqueElement());
    }

    private static BinaryOperator<TypePeakAndPlateRuleUIO> selectUniqueElement() {
        return (licensePlateNumberTypeUIO, licensePlateNumberTypeUIO2) -> licensePlateNumberTypeUIO;
    }

    private static Predicate<TypePeakAndPlateRuleUIO> itRepresentsThisLastNumber(Integer lastNumberCanBeNotOnRoad) {
        return licensePlateNumberTypeUIO ->
                licensePlateNumberTypeUIO.lastNumbers.contains(lastNumberCanBeNotOnRoad);
    }
}