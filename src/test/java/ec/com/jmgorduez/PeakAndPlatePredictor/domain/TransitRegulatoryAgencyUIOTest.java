package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO.LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransitRegulatoryAgencyUIOTest {

    private TransitRegulatoryAgencyUIO transitRegulatoryAgencyUIOUnderTest;

    @BeforeEach
    void setUp() {
        transitRegulatoryAgencyUIOUnderTest = new TransitRegulatoryAgencyUIO();
    }

    @Test
    void instanceLicensePlateNumber() {
        assertThat(transitRegulatoryAgencyUIOUnderTest.instanceLicensePlateNumber(PCI_8580))
                .isEqualTo(NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS);
        assertThat(transitRegulatoryAgencyUIOUnderTest.instanceLicensePlateNumber(PCI_8581))
                .isEqualTo(NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS);
        assertThat(transitRegulatoryAgencyUIOUnderTest.instanceLicensePlateNumber(PCI_8584))
                .isEqualTo(NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_WEDNESDAYS);
        assertThat(transitRegulatoryAgencyUIOUnderTest.instanceLicensePlateNumber(PCI_8585))
                .isEqualTo(NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_WEDNESDAYS);
    }

}