package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LocalDateCheckerUIOTest {

    private LocalDateCheckerUIO localDateCheckerUIOUnderTest;

    @BeforeEach
    void setUp() {
        localDateCheckerUIOUnderTest = new LocalDateCheckerUIO();
    }

    @Test
    void isNotAHoliday() {
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(_15_04_2019))
                .isTrue();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(_04_11_2019))
                .isFalse();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(_01_01_2019))
                .isFalse();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(_20_04_2019))
                .isTrue();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(_03_11_2019))
                .isTrue();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(_24_05_2019))
                .isFalse();
        assertThat(localDateCheckerUIOUnderTest.isNotAHoliday(_01_01_2019))
                .isTrue();
    }

    @Test
    void isNotAWeekendDay() {
        assertThat(localDateCheckerUIOUnderTest.isNotAWeekendDay(_15_04_2019))
                .isTrue();
        assertThat(localDateCheckerUIOUnderTest.isNotAWeekendDay(_20_04_2019))
                .isFalse();
        assertThat(localDateCheckerUIOUnderTest.isNotAWeekendDay(_21_04_2019))
                .isFalse();
    }

    @Test
    void holidays() {
        assertThat(localDateCheckerUIOUnderTest.holidays(_2019))
                .contains(_01_01_2019)
                .contains(_04_11_2019)
                .doesNotContain(_03_11_2019)
                .doesNotContain(_15_04_2019);
    }
}