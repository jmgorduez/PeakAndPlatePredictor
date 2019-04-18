package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.PCI_8580;
import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.PCI_8580_2019_04_15_07_00;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PeakAndPlateLineSplitterTest {

    private PeakAndPlateLineSplitter peakAndPlateLineSplitterUnderTest;

    @BeforeEach
    void setUp() {
        peakAndPlateLineSplitterUnderTest = new PeakAndPlateLineSplitter(PCI_8580_2019_04_15_07_00);
    }

    @Test
    void licensePlateNumber() {
        assertThat(peakAndPlateLineSplitterUnderTest.licensePlateNumber())
                .isEqualTo(PCI_8580);
    }

    @Test
    void date() {
    }

    @Test
    void time() {
    }
}