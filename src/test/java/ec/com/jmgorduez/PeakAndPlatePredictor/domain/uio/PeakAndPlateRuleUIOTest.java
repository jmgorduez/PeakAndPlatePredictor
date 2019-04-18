package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio;

import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateStatus.NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateStatus.ON_THE_ROAD;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateRuleUIOTest {

    private PeakAndPlateRuleUIO licensePlateNumberUIOUnderTest;

    @Test
    void peakAndPlateStatusOnMondays() {
        licensePlateNumberUIOUnderTest = MONDAYS_NOT_ON_THE_ROAD;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_15_2019, _08_00))
                .isEqualTo(NOT_ON_THE_ROAD);
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_16_2019, _19_31))
                .isEqualTo(ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusOnFridays() {
        licensePlateNumberUIOUnderTest = FRIDAYS_NOT_ON_THE_ROAD;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_19_2019, _07_00))
                .isEqualTo(NOT_ON_THE_ROAD);
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_16_2019, _19_31))
                .isEqualTo(ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusOnSaturdays() {
        licensePlateNumberUIOUnderTest = FRIDAYS_NOT_ON_THE_ROAD;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_20_2019, _08_00))
                .isEqualTo(ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateDate() {
        licensePlateNumberUIOUnderTest = MONDAYS_NOT_ON_THE_ROAD;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_16_2019, _09_31))
                .isEqualTo(ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateTime() {
        licensePlateNumberUIOUnderTest = MONDAYS_NOT_ON_THE_ROAD;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(APR_16_2019, _19_31))
                .isEqualTo(ON_THE_ROAD);
    }

    @Test
    void isAPeakAndPlateDate() {
        licensePlateNumberUIOUnderTest = MONDAYS_NOT_ON_THE_ROAD;
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
        licensePlateNumberUIOUnderTest = MONDAYS_NOT_ON_THE_ROAD;
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
}