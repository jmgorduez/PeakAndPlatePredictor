package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ITransitRegulatoryAgency;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;

public class TransitRegulatoryAgencyUIO implements ITransitRegulatoryAgency {

    @Override
    public IPeakAndPlateRule instanceLicensePlateNumber(String value) {
        Integer lastNumber = lastCharacter(value);
        return new PeakAndPlateRuleUIO(LicensePlateNumberTypeUIO.instance(lastNumber).get());
    }

    private int lastCharacter(String value) {
        return Character.getNumericValue(value.charAt(value.length() - ONE));
    }

}
