package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.factories.PeakAndPlateRuleFactoryUIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlateRuleFactoryUIOTest {

    private static final String typePeakAndPlateRuleUIO = "typePeakAndPlateRuleUIO";
    private PeakAndPlateRuleFactoryUIO peakAndPlateRuleFactoryUIO;

    @BeforeEach
    void setUp() {
        peakAndPlateRuleFactoryUIO = new PeakAndPlateRuleFactoryUIO();
    }

    @Test
    void instanceRule() {

        assertThat(peakAndPlateRuleFactoryUIO.instanceRule(PCI_8580))
                .isEqualToComparingOnlyGivenFields(MONDAYS_NOT_ON_THE_ROAD, typePeakAndPlateRuleUIO);
        assertThat(peakAndPlateRuleFactoryUIO.instanceRule(PCI_8581))
                .isEqualToComparingOnlyGivenFields(MONDAYS_NOT_ON_THE_ROAD, typePeakAndPlateRuleUIO);
        assertThat(peakAndPlateRuleFactoryUIO.instanceRule(PCI_8584))
                .isEqualToComparingOnlyGivenFields(WEDNESDAYS_NOT_ON_THE_ROAD, typePeakAndPlateRuleUIO);
        assertThat(peakAndPlateRuleFactoryUIO.instanceRule(PCI_8585))
                .isEqualToComparingOnlyGivenFields(WEDNESDAYS_NOT_ON_THE_ROAD, typePeakAndPlateRuleUIO);
    }

}