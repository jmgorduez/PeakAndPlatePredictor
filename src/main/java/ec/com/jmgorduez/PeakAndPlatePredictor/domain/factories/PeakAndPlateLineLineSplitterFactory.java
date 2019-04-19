package ec.com.jmgorduez.PeakAndPlatePredictor.domain.factories;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateLineSplitterFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.utils.IPeakAndPlateLineSplitter;
import ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants;
import ec.com.jmgorduez.PeakAndPlatePredictor.utils.PeakAndPlateLineSplitter;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.BLANK_SPACE_CHAR;

public class PeakAndPlateLineLineSplitterFactory implements IPeakAndPlateLineSplitterFactory {
    @Override
    public IPeakAndPlateLineSplitter instanceSplitter(String value) {
        return new PeakAndPlateLineSplitter(value, BLANK_SPACE_CHAR, LocalDate::parse, LocalTime::parse);
    }
}
