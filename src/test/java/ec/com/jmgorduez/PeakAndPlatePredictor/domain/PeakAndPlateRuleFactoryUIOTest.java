package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateRuleFactoryUIOTest {

    private PeakAndPlateRuleFactoryUIO transitRegulatoryAgencyUIOUnderTest;

    @BeforeEach
    void setUp() {
        transitRegulatoryAgencyUIOUnderTest = new PeakAndPlateRuleFactoryUIO();
    }

    @Test
    void instanceRule() {
        assertThat(transitRegulatoryAgencyUIOUnderTest.instanceRule(PCI_8580))
                .isEqualTo(CAN_NOT_ON_THE_ROAD_ON_MONDAYS);
        assertThat(transitRegulatoryAgencyUIOUnderTest.instanceRule(PCI_8581))
                .isEqualTo(CAN_NOT_ON_THE_ROAD_ON_MONDAYS);
        assertThat(transitRegulatoryAgencyUIOUnderTest.instanceRule(PCI_8584))
                .isEqualTo(CAN_NOT_ON_THE_ROAD_ON_WEDNESDAYS);
        assertThat(transitRegulatoryAgencyUIOUnderTest.instanceRule(PCI_8585))
                .isEqualTo(CAN_NOT_ON_THE_ROAD_ON_WEDNESDAYS);
    }

}