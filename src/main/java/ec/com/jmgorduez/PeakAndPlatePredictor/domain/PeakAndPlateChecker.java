package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRule;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ITransitRegulatoryAgency;
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

    @Override
    public void checkPeakAndPlate(Supplier<String> readLine,
                                  Supplier<ITransitRegulatoryAgency> transitRegulatoryAgency,
                                  Function<String, LocalDate> instanceDate,
                                  Function<String, LocalTime> instanceTime,
                                  BiConsumer<String, PeakAndPlateStatus> writeOutputConsumer) {
        String line = readLine.get();
        if (isNotEmptyLine(line)) {
            Queue<String> parameters = getParameters(line);
            IPeakAndPlateRule licensePlateNumber
                    = takeLicensePlateNumber(transitRegulatoryAgency.get()::instanceLicensePlateNumber,
                    parameters);
            LocalDate date = takeDate(instanceDate, parameters);
            LocalTime time = takeTime(instanceTime, parameters);
            writeOutput(writeOutputConsumer, line, licensePlateNumber, date, time);
            checkPeakAndPlate(readLine, transitRegulatoryAgency, instanceDate, instanceTime, writeOutputConsumer);
        }
    }

    private void writeOutput(BiConsumer<String, PeakAndPlateStatus> writeOutputConsumer,
                             String line,
                             IPeakAndPlateRule licensePlateNumber,
                             LocalDate date,
                             LocalTime time) {
        writeOutputConsumer.accept(line, getPeakAndPlateStatus(licensePlateNumber, date, time));
    }

    private LocalTime takeTime(Function<String, LocalTime> instanceTime, Queue<String> parameters) {
        return instanceTime.apply(parameters.poll());
    }

    private LocalDate takeDate(Function<String, LocalDate> instanceDate, Queue<String> parameters) {
        return instanceDate.apply(parameters.poll());
    }

    private boolean isNotEmptyLine(String line) {
        return line != null;
    }

    private PeakAndPlateStatus getPeakAndPlateStatus(IPeakAndPlateRule licensePlateNumber,
                                                     LocalDate date,
                                                     LocalTime time) {
        return licensePlateNumber.peakAndPlateStatusAt(date, time);
    }

    private IPeakAndPlateRule takeLicensePlateNumber(Function<String, IPeakAndPlateRule> instanceLicensePlateNumber,
                                                     Queue<String> parameters) {
        return instanceLicensePlateNumber.apply(parameters.poll());
    }

    private ArrayDeque<String> getParameters(String line) {
        return new ArrayDeque<>(Arrays.asList(line.split(BLANK_SPACE_STRING)));
    }
}
