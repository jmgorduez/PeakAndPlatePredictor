package ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums;

import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.TypePeakAndPlateRuleUIO.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.NINE;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.ZERO;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;

class TypePeakAndPlateRuleUIOTest {

    @Test
    void canBeOnRoadAt() {
        assertThat(CAN_BE_NOT_ON_ROAD_ON_TUESDAYS.canBeOnRoadAt(FRIDAY))
                .isTrue();
        assertThat(CAN_BE_NOT_ON_ROAD_ON_FRIDAYS.canBeOnRoadAt(FRIDAY))
                .isFalse();
        assertThat(CAN_BE_NOT_ON_ROAD_ON_MONDAYS.canBeOnRoadAt(MONDAY))
                .isFalse();
    }

    @Test
    void instance() {
        assertThat(TypePeakAndPlateRuleUIO.instance(ZERO))
                .isEqualTo(of(CAN_BE_NOT_ON_ROAD_ON_MONDAYS));
        assertThat(TypePeakAndPlateRuleUIO.instance(NINE))
                .isEqualTo(of(CAN_BE_NOT_ON_ROAD_ON_FRIDAYS));
        assertThat(TypePeakAndPlateRuleUIO.instance(Integer.MAX_VALUE))
                .isEqualTo(empty());
    }
}