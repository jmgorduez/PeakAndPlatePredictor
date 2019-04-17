package ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface InputProcessor {
    void processInput(Supplier<String> readLine,
                      Function<String, ILicensePlateNumber> parseLicensePlateNumber,
                      Function<String, LocalDate> parseDate,
                      Function<String, LocalTime> parseTime,
                      Consumer<IResponse> writeOutput);
}

