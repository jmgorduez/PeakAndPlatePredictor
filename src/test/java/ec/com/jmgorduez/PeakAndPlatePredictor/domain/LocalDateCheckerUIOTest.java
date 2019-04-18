package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

class LocalDateCheckerUIOTest {

    private LocalDateCheckerUIO localDateCheckerUIOUnderTest;

    @BeforeEach
    void setUp() {
        localDateCheckerUIOUnderTest = new LocalDateCheckerUIO();
    }

    @Test
    void isNotAHoliday() {
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(APR_15_2019))
                .isTrue();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(NOV_04_2019))
                .isFalse();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(JAN_01_2019))
                .isFalse();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(APR_20_2019))
                .isTrue();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(NOV_03_2019))
                .isTrue();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(MAY_24_2019))
                .isFalse();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(MAY_01_2019))
                .isTrue();
    }

    @Test
    void isNotAWeekendDay() {
        assertThat(localDateCheckerUIOUnderTest.isNotAWeekendDay(APR_15_2019))
                .isTrue();
        assertThat(localDateCheckerUIOUnderTest.isNotAWeekendDay(APR_20_2019))
                .isFalse();
        assertThat(localDateCheckerUIOUnderTest.isNotAWeekendDay(APR_21_2019))
                .isFalse();
    }

    @Test
    void holidays() {
        assertThat(localDateCheckerUIOUnderTest.holidays(_2019))
                .contains(JAN_01_2019)
                .contains(NOV_04_2019)
                .doesNotContain(NOV_03_2019)
                .doesNotContain(APR_15_2019);
    }
}