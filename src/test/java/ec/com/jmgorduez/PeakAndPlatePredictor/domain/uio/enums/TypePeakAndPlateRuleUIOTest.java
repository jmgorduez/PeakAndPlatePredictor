package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.enums;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.enums.TypePeakAndPlateRuleUIO;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.enums.TypePeakAndPlateRuleUIO.*;
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
        assertThat(TUESDAYS_NOT_ON_ROAD.canBeOnRoadAt(FRIDAY))
                .isTrue();
        assertThat(FRIDAYS_NOT_ON_ROAD.canBeOnRoadAt(FRIDAY))
                .isFalse();
        assertThat(MONDAYS_NOT_ON_ROAD.canBeOnRoadAt(MONDAY))
                .isFalse();
    }

    @Test
    void instance() {
        assertThat(TypePeakAndPlateRuleUIO.instance(ZERO))
                .isEqualTo(of(MONDAYS_NOT_ON_ROAD));
        assertThat(TypePeakAndPlateRuleUIO.instance(NINE))
                .isEqualTo(of(FRIDAYS_NOT_ON_ROAD));
        assertThat(TypePeakAndPlateRuleUIO.instance(Integer.MAX_VALUE))
                .isEqualTo(empty());
    }
}