package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateLineSplitter;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateRuleFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateSplitterFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.NULL_STRING;
import static java.util.Optional.ofNullable;

public class PeakAndPlateChecker implements IPeakAndPlateChecker {

    private IPeakAndPlateRuleFactory peakAndPlateRuleFactory;
    private IPeakAndPlateSplitterFactory peakAndPlateSplitterFactory;

    public PeakAndPlateChecker(IPeakAndPlateSplitterFactory splitterFactory,
                               IPeakAndPlateRuleFactory ruleFactory) {
        this.peakAndPlateRuleFactory = ruleFactory;
        this.peakAndPlateSplitterFactory = splitterFactory;
    }

    @Override
    public void checkPeakAndPlate(Supplier<String> readInputLine,
                                  BiConsumer<String, PeakAndPlateStatus> writeOutputLine) {
        ofNullable(readInputLine.get())
                .map(this::mapEmptyStringToNull)
                .ifPresent(inputLine -> {
                    IPeakAndPlateLineSplitter lineSplitter = lineSplitter(inputLine);
                    IPeakAndPlateRule peakAndPlateRule = peakAndPlateRule(lineSplitter::licensePlateNumber);
                    writeOutputLine.accept(inputLine, peakAndPlateStatus(peakAndPlateRule, lineSplitter::date, lineSplitter::time));
                    checkPeakAndPlate(readInputLine, writeOutputLine);
                });
    }

    private String mapEmptyStringToNull(String line) {
        return line.isEmpty() ? NULL_STRING : line;
    }

    private PeakAndPlateStatus peakAndPlateStatus(IPeakAndPlateRule peakAndPlateRule, Supplier<LocalDate> date, Supplier<LocalTime> time) {
        return peakAndPlateRule.peakAndPlateStatusAt(date.get(), time.get());
    }

    private IPeakAndPlateLineSplitter lineSplitter(String inputLine) {
        return peakAndPlateSplitterFactory.instanceSplitter(inputLine);
    }

    private IPeakAndPlateRule peakAndPlateRule(Supplier<String> licensePlateNumberString) {
        return peakAndPlateRuleFactory.instanceRule(licensePlateNumberString.get());
    }
}
