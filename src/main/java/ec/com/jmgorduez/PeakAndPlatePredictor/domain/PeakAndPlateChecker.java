package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateLineSplitter;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Optional;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.BLANK_SPACE_STRING;
import static java.util.Optional.ofNullable;

public class PeakAndPlateChecker implements IPeakAndPlateChecker {

    private Function<String, IPeakAndPlateRule> instancePeakAndPlateRule;
    private Function<String, IPeakAndPlateLineSplitter> instanPeakAndPlateLineSplitter;

    public PeakAndPlateChecker(Function<String, IPeakAndPlateLineSplitter> instanPeakAndPlateLineSplitter,
                               Function<String, IPeakAndPlateRule> instancePeakAndPlateRule) {
        this.instancePeakAndPlateRule = instancePeakAndPlateRule;
        this.instanPeakAndPlateLineSplitter = instanPeakAndPlateLineSplitter;
    }

    @Override
    public void checkPeakAndPlate(Supplier<String> readInputLine,
                                  BiConsumer<String, PeakAndPlateStatus> writeOutputLine) {
        ofNullable(readInputLine.get())
                .ifPresent(inputLine -> {
                    IPeakAndPlateLineSplitter lineSplitter = lineSplitter(inputLine);
                    IPeakAndPlateRule peakAndPlateRule = instancePeakAndPlateRule(lineSplitter::licensePlateNumber);
                    writeOutputLine.accept(inputLine, peakAndPlateStatus(lineSplitter, peakAndPlateRule));
                    checkPeakAndPlate(readInputLine, writeOutputLine);
                });
    }

    private PeakAndPlateStatus peakAndPlateStatus(IPeakAndPlateLineSplitter lineSplitter, IPeakAndPlateRule peakAndPlateRule) {
        return peakAndPlateRule.peakAndPlateStatusAt(lineSplitter.date(), lineSplitter.time());
    }

    private IPeakAndPlateLineSplitter lineSplitter(String inputLine) {
        return instanPeakAndPlateLineSplitter.apply(inputLine);
    }

    private IPeakAndPlateRule instancePeakAndPlateRule(Supplier<String> licensePlateNumberString) {
        return instancePeakAndPlateRule.apply(licensePlateNumberString.get());
    }
}
