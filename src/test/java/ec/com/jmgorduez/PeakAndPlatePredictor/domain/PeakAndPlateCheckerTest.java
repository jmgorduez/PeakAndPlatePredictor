package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ITransitRegulatoryAgency;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateCheckerTest {

    private PeakAndPlateChecker peakAndPlateCheckerUnderTest;
    private List<String> outputs;
    private Integer lineReadCount;

    @BeforeEach
    void setUp() {
        peakAndPlateCheckerUnderTest = new PeakAndPlateChecker();
        outputs = new ArrayList<>();
        lineReadCount = ZERO;
    }

    @Test
    void checkPeakAndPlateEmptyInput() {
        lineReadCount = FOUR;
        peakAndPlateCheckerUnderTest
                .checkPeakAndPlate(this::readLine,
                        this::transitRegulatoryAgency,
                        LocalDate::parse,
                        LocalTime::parse,
                        this::writeOutput);
        assertThat(outputs.isEmpty())
                .isTrue();
    }

    @Test
    void checkPeakAndPlate() {
        peakAndPlateCheckerUnderTest
                .checkPeakAndPlate(this::readLine,
                        this::transitRegulatoryAgency,
                        LocalDate::parse,
                        LocalTime::parse,
                        this::writeOutput);
        assertThat(outputs.isEmpty())
                .isFalse();
        assertThat(outputs.get(ZERO))
                .isEqualTo(PCI_8580_2019_04_15_07_00.concat(CAN_BE_NOT_ON_THE_ROAD.name()));
        assertThat(outputs.get(ONE))
                .isEqualTo(PCI_8580_2019_04_15_10_00.concat(CAN_BE_ON_THE_ROAD.name()));
        assertThat(outputs.get(TWO))
                .isEqualTo(PCI_8581_2019_04_16_07_00.concat(CAN_BE_NOT_ON_THE_ROAD.name()));
    }

    String readLine() {
        lineReadCount++;
        switch (lineReadCount) {
            case 1:
                return PCI_8580_2019_04_15_07_00;
            case 2:
                return PCI_8580_2019_04_15_10_00;
            case 3:
                return PCI_8581_2019_04_16_07_00;
            default:
                return null;
        }
    }

    ITransitRegulatoryAgency transitRegulatoryAgency() {
        return new TransitRegulatoryAgencyUIO();
    }

    void writeOutput(String input, PeakAndPlateStatus peakAndPlateStatusOutput) {
        outputs.add(input.concat(peakAndPlateStatusOutput.name()));
    }
}