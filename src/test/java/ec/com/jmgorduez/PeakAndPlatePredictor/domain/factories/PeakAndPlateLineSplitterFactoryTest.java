package ec.com.jmgorduez.PeakAndPlatePredictor.domain.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils.IPeakAndPlateLineSplitter;
import ec.com.jmgorduez.PeakAndPlatePredictor.utils.PeakAndPlateLineSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.PCI_8580_2019_04_15_10_00;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;

class PeakAndPlateLineSplitterFactoryTest {

    private static final String licensePlateNumber = "licensePlateNumber";
    private PeakAndPlateLineSplitterFactory peakAndPlateLineSplitterFactoryUnderTest;

    @BeforeEach
    void setUp() {
        peakAndPlateLineSplitterFactoryUnderTest = new PeakAndPlateLineSplitterFactory();
    }

    @Test
    void instanceSplitter() {
        assertThat(peakAndPlateLineSplitterFactoryUnderTest.instanceSplitter(PCI_8580_2019_04_15_10_00))
                .isEqualToComparingOnlyGivenFields(new PeakAndPlateLineSplitter(PCI_8580_2019_04_15_10_00,
                        LocalDate::parse, LocalTime::parse), licensePlateNumber);
    }
}