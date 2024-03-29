package ec.com.jmgorduez.PeakAndPlatePredictor.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.BLANK_SPACE_CHAR;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateLineSplitterTest {

    private PeakAndPlateLineSplitter peakAndPlateLineSplitterUnderTest;

    @BeforeEach
    void setUp() {
        peakAndPlateLineSplitterUnderTest = new PeakAndPlateLineSplitter(PCI_8580_2019_04_15_07_00,
                BLANK_SPACE_CHAR, LocalDate::parse, LocalTime::parse);
    }

    @Test
    void licensePlateNumber() {
        assertThat(peakAndPlateLineSplitterUnderTest.licensePlateNumber())
                .isEqualTo(PCI_8580);
    }

    @Test
    void date() {
        assertThat(peakAndPlateLineSplitterUnderTest.date())
                .isEqualTo(APR_15_2019);
    }

    @Test
    void time() {
        assertThat(peakAndPlateLineSplitterUnderTest.time())
                .isEqualTo(_07_00);
    }
}