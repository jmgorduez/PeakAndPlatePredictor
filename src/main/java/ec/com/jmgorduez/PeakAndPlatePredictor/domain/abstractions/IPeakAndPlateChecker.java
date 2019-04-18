package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;


import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface IPeakAndPlateChecker {
    void checkPeakAndPlate(Supplier<String> readInputLine,
                           Function<String, IPeakAndPlateRule> instancePeakAndPlateRule,
                           BiConsumer<String, PeakAndPlateStatus> writeOutputLine);
}

