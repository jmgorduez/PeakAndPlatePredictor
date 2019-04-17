package ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.Optional;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.ZERO;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LicensePlateNumberTypeUIOTest {

    @Test
    void canBeOnRoadAt() {
        assertThat(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_TUESDAYS.canBeOnRoadAt(FRIDAY))
                .isTrue();
        assertThat(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_FRIDAYS.canBeOnRoadAt(FRIDAY))
                .isFalse();
        assertThat(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS.canBeOnRoadAt(MONDAY))
                .isFalse();
    }

    @Test
    void instance() {
    }
}