package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.enums;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static java.time.DayOfWeek.*;

public enum TypePeakAndPlateRuleUIO {
    MONDAYS_NOT_ON_ROAD(MONDAY, ZERO, ONE),
    TUESDAYS_NOT_ON_ROAD(TUESDAY, TWO, THREE),
    WEDNESDAYS_NOT_ON_ROAD(WEDNESDAY, FOUR, FIVE),
    THURSDAYS_NOT_ON_ROAD(THURSDAY, SIX, SEVEN),
    FRIDAYS_NOT_ON_ROAD(FRIDAY, EIGHT, NINE);

    private final DayOfWeek dayOfWeekCanBeNotOnRoad;
    private final List<Integer> lastNumbers;

    TypePeakAndPlateRuleUIO(DayOfWeek dayOfWeekCanBeNotOnRoad, Integer... lastNumbers) {
        this.dayOfWeekCanBeNotOnRoad = dayOfWeekCanBeNotOnRoad;
        this.lastNumbers = Arrays.asList(lastNumbers);
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
        return (TypeRuleUIO, TypeRuleUIO2) -> TypeRuleUIO;
    }

    private static Predicate<TypePeakAndPlateRuleUIO> itRepresentsThisLastNumber(Integer lastNumber) {
        return TypeRuleUIO ->
                TypeRuleUIO.lastNumbers.contains(lastNumber);
    }
}