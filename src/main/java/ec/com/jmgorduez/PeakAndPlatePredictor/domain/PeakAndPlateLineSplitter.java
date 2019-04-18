package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateLineSplitter;

import java.time.LocalDate;
import java.time.LocalTime;

public class PeakAndPlateLineSplitter implements IPeakAndPlateLineSplitter {

    public PeakAndPlateLineSplitter(String line){

    }

    @Override
    public String licensePlateNumber() {
        return null;
    }

    @Override
    public LocalDate date() {
        return null;
    }

    @Override
    public LocalTime time() {
        return null;
    }
}
