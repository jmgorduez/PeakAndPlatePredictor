package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
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
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PeakAndPlateCheckerTest {

    private PeakAndPlateChecker peakAndPlateCheckerUnderTest;
    private List<String> outputs;

    @BeforeEach
    void setUp(){
        peakAndPlateCheckerUnderTest = new PeakAndPlateChecker();
        outputs = new ArrayList<>();
    }

    @Test
    void checkPeakAndPlate_PCI_8580_2019_04_15_07_00() {
        peakAndPlateCheckerUnderTest.checkPeakAndPlate(() -> PCI_8580_2019_04_15_07_00,
                this::transitRegulatoryAgency,
                s -> _15_04_2019,
                s -> _07_00,
                this::writeOutput);
        assertThat(outputs.isEmpty())
                .isFalse();
        assertThat(outputs.get(ZERO))
                .isEqualTo(PCI_8580_2019_04_15_07_00.concat(CAN_BE_NOT_ON_THE_ROAD.name()));
    }

    ITransitRegulatoryAgency transitRegulatoryAgency(){
        return new TransitRegulatoryAgencyUIO();
    }

    void writeOutput(String input, PeakAndPlateStatus peakAndPlateStatusOutput){
        outputs.add(input.concat(peakAndPlateStatusOutput.name()));
    }
}