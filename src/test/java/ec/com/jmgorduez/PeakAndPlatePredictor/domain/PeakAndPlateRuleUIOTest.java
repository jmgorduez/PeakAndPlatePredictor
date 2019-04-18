package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.TypePeakAndPlateRuleUIO.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateRuleUIOTest {

    private PeakAndPlateRuleUIO licensePlateNumberUIOUnderTest;

    @Test
    void peakAndPlateStatusOnMondays() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_15_04_2019, _08_00))
                .isEqualTo(CAN_BE_NOT_ON_THE_ROAD);
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_16_04_2019, _19_31))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusOnFridays() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_FRIDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_19_04_2019, _07_00))
                .isEqualTo(CAN_BE_NOT_ON_THE_ROAD);
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_16_04_2019, _19_31))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusOnSaturdays() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_FRIDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_20_04_2019, _08_00))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateDate() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_16_04_2019, _09_31))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateTime() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_16_04_2019, _19_31))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void isAPeakAndPlateDate() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateDate(_20_04_2019))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateDate(_15_04_2019))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateDate(_01_01_2019))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateDate(_04_11_2019))
                .isFalse();
    }

    @Test
    void isAPeakAndPlateTime() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateTime(_07_00))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateTime(_08_00))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateTime(_09_30))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateTime(_09_31))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateTime(_16_00))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateTime(_19_30))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateTime(_19_31))
                .isFalse();
    }

    @Test
    void equals() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest.equals(licensePlateNumberUIOUnderTest))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.equals(this))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest
                .equals(new PeakAndPlateRuleUIO(CAN_BE_NOT_ON_ROAD_ON_TUESDAYS)))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest
                .equals(new PeakAndPlateRuleUIO(CAN_BE_NOT_ON_ROAD_ON_MONDAYS)))
                .isTrue();
    }
}