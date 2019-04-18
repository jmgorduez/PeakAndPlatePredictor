package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.refEq;

class PeakAndPlateRuleFactoryUIOTest {

    private PeakAndPlateRuleFactoryUIO peakAndPlateRuleFactoryUIO;

    @BeforeEach
    void setUp() {
        peakAndPlateRuleFactoryUIO = new PeakAndPlateRuleFactoryUIO();
    }

    @Test
    void instanceRule() {

        assertThat(refEq(peakAndPlateRuleFactoryUIO.instanceRule(PCI_8580)))
                .isEqualTo(refEq(MONDAYS_NOT_ON_THE_ROAD));
        assertThat(refEq(peakAndPlateRuleFactoryUIO.instanceRule(PCI_8581)))
                .isEqualTo(refEq(MONDAYS_NOT_ON_THE_ROAD));
        assertThat(refEq(peakAndPlateRuleFactoryUIO.instanceRule(PCI_8584)))
                .isEqualTo(refEq(WEDNESDAYS_NOT_ON_THE_ROAD));
        assertThat(refEq(peakAndPlateRuleFactoryUIO.instanceRule(PCI_8585)))
                .isEqualTo(refEq(WEDNESDAYS_NOT_ON_THE_ROAD));
    }

}