package ec.com.jmgorduez.PeakAndPlatePredictor.domain.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.utils.PeakAndPlateLineSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.PCI_8580_2019_04_15_10_00;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateLineSplitterFactoryTest {

    private static final String licensePlateNumber = "licensePlateNumber";
    private PeakAndPlateLineLineSplitterFactory peakAndPlateLineSplitterFactoryUnderTest;

    @BeforeEach
    void setUp() {
        peakAndPlateLineSplitterFactoryUnderTest = new PeakAndPlateLineLineSplitterFactory();
    }

    @Test
    void instanceSplitter() {
        assertThat(peakAndPlateLineSplitterFactoryUnderTest.instanceSplitter(PCI_8580_2019_04_15_10_00))
                .isEqualToComparingOnlyGivenFields(new PeakAndPlateLineSplitter(PCI_8580_2019_04_15_10_00,
                        LocalDate::parse, LocalTime::parse), licensePlateNumber);
    }
}