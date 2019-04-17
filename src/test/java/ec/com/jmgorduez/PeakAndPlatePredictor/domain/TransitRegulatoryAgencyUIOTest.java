package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransitRegulatoryAgencyUIOTest {

    private TransitRegulatoryAgencyUIO transitRegulatoryAgencyUIOUnderTest;

    @BeforeEach
    void setUp() {
        transitRegulatoryAgencyUIOUnderTest = new TransitRegulatoryAgencyUIO();
    }

    @Test
    void isAPeakAndPlateDate() {
    }

    @Test
    void isAPeakAndPlateTime() {
        assertThat(transitRegulatoryAgencyUIOUnderTest.isAPeakAndPlateTime(_07_00))
                .isTrue();
        assertThat(transitRegulatoryAgencyUIOUnderTest.isAPeakAndPlateTime(_08_00))
                .isTrue();
        assertThat(transitRegulatoryAgencyUIOUnderTest.isAPeakAndPlateTime(_09_30))
                .isTrue();
        assertThat(transitRegulatoryAgencyUIOUnderTest.isAPeakAndPlateTime(_09_31))
                .isFalse();
        assertThat(transitRegulatoryAgencyUIOUnderTest.isAPeakAndPlateTime(_16_00))
                .isTrue();
        assertThat(transitRegulatoryAgencyUIOUnderTest.isAPeakAndPlateTime(_19_30))
                .isTrue();
        assertThat(transitRegulatoryAgencyUIOUnderTest.isAPeakAndPlateTime(_19_31))
                .isFalse();
    }

    @Test
    void instanceLicensePlateNumber() {
    }
}