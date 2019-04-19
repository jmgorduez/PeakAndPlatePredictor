package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils.IPeakAndPlateLineSplitter;

public interface IPeakAndPlateLineSplitterFactory {
    IPeakAndPlateLineSplitter instanceSplitter(String value);
}
