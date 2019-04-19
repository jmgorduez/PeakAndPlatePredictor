package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;


import ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateStatus;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public interface IPeakAndPlateChecker {
    void checkPeakAndPlate(Supplier<String> readInputLine,
                           BiConsumer<String, PeakAndPlateStatus> writeOutputLine);
}

