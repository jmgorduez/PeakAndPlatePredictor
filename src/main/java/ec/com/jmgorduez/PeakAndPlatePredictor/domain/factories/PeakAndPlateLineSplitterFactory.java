package ec.com.jmgorduez.PeakAndPlatePredictor.domain.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateSplitterFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils.IPeakAndPlateLineSplitter;

public class PeakAndPlateLineSplitterFactory implements IPeakAndPlateSplitterFactory {
    @Override
    public IPeakAndPlateLineSplitter instanceSplitter(String value) {
        return null;
    }
}
