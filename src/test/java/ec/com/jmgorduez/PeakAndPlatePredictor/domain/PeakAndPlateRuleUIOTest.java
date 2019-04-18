package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.TypePeakAndPlateRuleUIO.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateRuleUIOTest {

    private PeakAndPlateRuleUIO licensePlateNumberUIOUnderTest;

    @Test
    void peakAndPlateStatusOnMondays() {
        licensePlateNumberUIOUnderTest = CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_15_2019, _08_00))
                .isEqualTo(CAN_BE_NOT_ON_THE_ROAD);
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_16_2019, _19_31))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusOnFridays() {
        licensePlateNumberUIOUnderTest = CAN_NOT_ON_THE_ROAD_ON_FRIDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_19_2019, _07_00))
                .isEqualTo(CAN_BE_NOT_ON_THE_ROAD);
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_16_2019, _19_31))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusOnSaturdays() {
        licensePlateNumberUIOUnderTest = CAN_NOT_ON_THE_ROAD_ON_FRIDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_20_2019, _08_00))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateDate() {
        licensePlateNumberUIOUnderTest = CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_16_2019, _09_31))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateTime() {
        licensePlateNumberUIOUnderTest = CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_16_2019, _19_31))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void isAPeakAndPlateDate() {
        licensePlateNumberUIOUnderTest = CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateDate(APR_20_2019))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateDate(APR_15_2019))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateDate(JAN_01_2019))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest.isAPeakAndPlateDate(NOV_04_2019))
                .isFalse();
    }

    @Test
    void isAPeakAndPlateTime() {
        licensePlateNumberUIOUnderTest = CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
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
        licensePlateNumberUIOUnderTest = CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
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