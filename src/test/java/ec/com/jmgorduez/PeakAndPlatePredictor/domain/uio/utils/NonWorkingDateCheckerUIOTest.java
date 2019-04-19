package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.utils;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.utils.NonWorkingDateCheckerUIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

class NonWorkingDateCheckerUIOTest {

    private NonWorkingDateCheckerUIO nonWorkingDateCheckerUIOUnderTest;

    @BeforeEach
    void setUp() {
        nonWorkingDateCheckerUIOUnderTest = new NonWorkingDateCheckerUIO();
    }

    @Test
    void isNotAHoliday() {
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAHoliday(APR_15_2019))
                .isTrue();
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAHoliday(NOV_04_2019))
                .isFalse();
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAHoliday(JAN_01_2019))
                .isFalse();
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAHoliday(APR_20_2019))
                .isTrue();
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAHoliday(NOV_03_2019))
                .isTrue();
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAHoliday(MAY_24_2019))
                .isFalse();
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAHoliday(MAY_01_2019))
                .isTrue();
    }

    @Test
    void isNotAWeekendDay() {
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAWeekendDay(APR_15_2019))
                .isTrue();
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAWeekendDay(APR_20_2019))
                .isFalse();
        assertThat(nonWorkingDateCheckerUIOUnderTest.isNotAWeekendDay(APR_21_2019))
                .isFalse();
    }

    @Test
    void holidays() {
        assertThat(nonWorkingDateCheckerUIOUnderTest.holidays(_2019))
                .contains(JAN_01_2019)
                .contains(NOV_04_2019)
                .doesNotContain(NOV_03_2019)
                .doesNotContain(APR_15_2019);
    }
}