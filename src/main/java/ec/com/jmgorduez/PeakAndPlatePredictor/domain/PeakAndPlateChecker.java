package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.BLANK_SPACE_STRING;

public class PeakAndPlateChecker implements IPeakAndPlateChecker {

    private Function<String, LocalDate> instanceDate;
    private Function<String, LocalTime> instanceTime;
    private Function<String, IPeakAndPlateRule> instancePeakAndPlateRule;

    public PeakAndPlateChecker(Function<String, LocalDate> instanceDate,
                               Function<String, LocalTime> instanceTime) {
        this.instanceDate = instanceDate;
        this.instanceTime = instanceTime;
    }

    @Override
    public void checkPeakAndPlate(Supplier<String> readInputLine,
                                  Function<String, IPeakAndPlateRule> instancePeakAndPlateRule,
                                  BiConsumer<String, PeakAndPlateStatus> writeOutputLine) {
        this.instancePeakAndPlateRule = instancePeakAndPlateRule;
        String inputLine = readInputLine.get();
        if (isNotEmptyLine(inputLine)) {
            Queue<String> parameters = splitParameters(inputLine);
            IPeakAndPlateRule peakAndPlateRule = instancePeakAndPlateRule(parameters::poll);
            PeakAndPlateStatus peakAndPlateStatus
                    = peakAndPlateRule.peakAndPlateStatusAt(instanceDate(parameters::poll),
                    instanceTime(parameters::poll));
            writeOutputLine.accept(inputLine, peakAndPlateStatus);
            checkPeakAndPlate(readInputLine, instancePeakAndPlateRule, writeOutputLine);
        }
    }

    private LocalTime instanceTime(Supplier<String> timeString) {
        return instanceTime.apply(timeString.get());
    }

    private LocalDate instanceDate(Supplier<String> dateString) {
        return instanceDate.apply(dateString.get());
    }

    private IPeakAndPlateRule instancePeakAndPlateRule(Supplier<String> licensePlateNumberString) {
        return instancePeakAndPlateRule.apply(licensePlateNumberString.get());
    }

    private boolean isNotEmptyLine(String line) {
        return line != null;
    }

    private ArrayDeque<String> splitParameters(String line) {
        return new ArrayDeque<>(Arrays.asList(line.split(BLANK_SPACE_STRING)));
    }
}
