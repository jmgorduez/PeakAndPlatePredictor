package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ITransitRegulatoryAgency;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransitRegulatoryAgencyUIO implements ITransitRegulatoryAgency {
    @Override
    public Boolean isAPeakAndPlateDate(LocalDate date) {
        return null;
    }

    @Override
    public Boolean isAPeakAndPlateTime(LocalTime time) {
        return null;
    }

    @Override
    public ILicensePlateNumber instanceLicensePlateNumber(String value) {
        return null;
    }
}
