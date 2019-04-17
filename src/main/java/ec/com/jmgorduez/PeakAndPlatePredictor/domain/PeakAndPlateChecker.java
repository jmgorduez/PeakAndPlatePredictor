package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ITransitRegulatoryAgency;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PeakAndPlateChecker implements IPeakAndPlateChecker {
    @Override
    public void checkPeakAndPlate(Supplier<String> readLineSupplier,
                                  Supplier<ITransitRegulatoryAgency> transitRegulatorSupplier,
                                  Function<String, LocalDate> instanceDate,
                                  Function<String, LocalTime> instanceTime,
                                  BiConsumer<String, PeakAndPlateStatus> writeOutputConsumer) {

    }
}
