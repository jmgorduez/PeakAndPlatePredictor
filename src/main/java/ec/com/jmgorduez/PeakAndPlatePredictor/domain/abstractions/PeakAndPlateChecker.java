package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;


import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface PeakAndPlateChecker {
    void checkPeakAndPlate(Supplier<String> readLineSupplier,
                      Supplier<ITransitRegulatoryAgency> transitRegulatorSupplier,
                      Function<String, ILicensePlateNumber> instanceLicensePlateNumber,
                      Function<String, LocalDate> instanceDate,
                      Function<String, LocalTime> instanceTime,
                      BiConsumer<String, PeakAndPlateStatus> writeOutputConsumer);
}

