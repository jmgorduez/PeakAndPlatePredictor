package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRuleFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.TypePeakAndPlateRuleUIO;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;

public class PeakAndPlateRuleFactoryUIO implements IPeakAndPlateRuleFactory {

    @Override
    public IPeakAndPlateRule instanceRule(String value) {
        Integer lastNumber = lastCharacter(value);
        return new PeakAndPlateRuleUIO(TypePeakAndPlateRuleUIO.instance(lastNumber).get());
    }

    private int lastCharacter(String value) {
        return Character.getNumericValue(value.charAt(value.length() - ONE));
    }

}