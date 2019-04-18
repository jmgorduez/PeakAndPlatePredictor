package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

public interface IPeakAndPlateRuleFactory {
    IPeakAndPlateRule instanceRule(String value);
}
