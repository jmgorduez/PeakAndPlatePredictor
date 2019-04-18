package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRuleFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateCheckerTest {

    private PeakAndPlateChecker peakAndPlateCheckerUnderTest;
    private PeakAndPlateRuleFactoryUIO peakAndPlateRuleFactoryUIO;
    private Queue<String> inputs;
    private List<String> outputs;

    @BeforeEach
    void setUp() {
        peakAndPlateRuleFactoryUIO = new PeakAndPlateRuleFactoryUIO();
        peakAndPlateCheckerUnderTest
                = new PeakAndPlateChecker(LocalDate::parse,
                LocalTime::parse);
        inputs = new ArrayDeque<>(Stream
                .of(PCI_8580_2019_04_15_07_00, PCI_8580_2019_04_15_10_00, PCI_8581_2019_04_16_07_00)
                .collect(Collectors.toList()));
        outputs = new ArrayList<>();
    }

    @Test
    void checkPeakAndPlateEmptyInput() {
        inputs.clear();
        peakAndPlateCheckerUnderTest
                .checkPeakAndPlate(inputs::poll, peakAndPlateRuleFactoryUIO::instanceRule, this::writeOutput);
        assertThat(outputs.isEmpty())
                .isTrue();
    }

    @Test
    void checkPeakAndPlate() {
        peakAndPlateCheckerUnderTest
                .checkPeakAndPlate(inputs::poll, peakAndPlateRuleFactoryUIO::instanceRule, this::writeOutput);
        assertThat(outputs.isEmpty())
                .isFalse();
        assertThat(outputs.get(ZERO))
                .isEqualTo(PCI_8580_2019_04_15_07_00.concat(BLANK_SPACE_STRING)
                        .concat(CAN_BE_NOT_ON_THE_ROAD.name()));
        assertThat(outputs.get(ONE))
                .isEqualTo(PCI_8580_2019_04_15_10_00.concat(BLANK_SPACE_STRING)
                        .concat(CAN_BE_ON_THE_ROAD.name()));
        assertThat(outputs.get(TWO))
                .isEqualTo(PCI_8581_2019_04_16_07_00.concat(BLANK_SPACE_STRING)
                        .concat(CAN_BE_ON_THE_ROAD.name()));
    }

    void writeOutput(String input, PeakAndPlateStatus peakAndPlateStatusOutput) {
        outputs.add(input.concat(BLANK_SPACE_STRING).concat(peakAndPlateStatusOutput.name()));
    }
}