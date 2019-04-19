package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;

public interface IPeakAndPlateRuleFactory {
    IPeakAndPlateRule instanceRule(String value);
}
