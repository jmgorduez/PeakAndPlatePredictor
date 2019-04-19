package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils.IPeakAndPlateLineSplitter;

public interface IPeakAndPlateSplitterFactory {
    IPeakAndPlateLineSplitter instanceSplitter(String value);
}
