package ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateRuleFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.PeakAndPlateRuleUIO;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.enums.TypePeakAndPlateRuleUIO;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.utils.NonWorkingDateCheckerUIO;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;

public class PeakAndPlateRuleFactoryUIO implements IPeakAndPlateRuleFactory {

    @Override
    public IPeakAndPlateRule instanceRule(String value) {
        Integer lastNumber = lastCharacter(value);
        return new PeakAndPlateRuleUIO(TypePeakAndPlateRuleUIO.instance(lastNumber).get(), new NonWorkingDateCheckerUIO());
    }

    private int lastCharacter(String value) {
        return Character.getNumericValue(value.charAt(value.length() - ONE));
    }

}
