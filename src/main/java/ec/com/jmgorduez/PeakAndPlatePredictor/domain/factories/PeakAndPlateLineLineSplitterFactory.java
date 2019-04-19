package ec.com.jmgorduez.PeakAndPlatePredictor.domain.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateLineSplitterFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils.IPeakAndPlateLineSplitter;
import ec.com.jmgorduez.PeakAndPlatePredictor.utils.PeakAndPlateLineSplitter;

import java.time.LocalDate;
import java.time.LocalTime;

public class PeakAndPlateLineLineSplitterFactory implements IPeakAndPlateLineSplitterFactory {
    @Override
    public IPeakAndPlateLineSplitter instanceSplitter(String value) {
        return new PeakAndPlateLineSplitter(value, LocalDate::parse, LocalTime::parse);
    }
}
