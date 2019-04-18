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
}