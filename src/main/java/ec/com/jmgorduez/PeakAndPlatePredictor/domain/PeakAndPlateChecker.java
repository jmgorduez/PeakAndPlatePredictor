package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.ILicensePlateNumber;
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
            ILicensePlateNumber licensePlateNumber
                    = takeLicensePlateNumber(transitRegulatoryAgency.get()::instanceLicensePlateNumber,
                    parameters);
            LocalDate date = takeDate(instanceDate, parameters);
            LocalTime time = takeTime(instanceTime, parameters);
            writeOutput(writeOutputConsumer, line, licensePlateNumber, date, time,
                    transitRegulatoryAgency.get()::isAPeakAndPlateDate,
                    transitRegulatoryAgency.get()::isAPeakAndPlateTime);
            checkPeakAndPlate(readLine, transitRegulatoryAgency, instanceDate, instanceTime, writeOutputConsumer);
        }
    }

    private void writeOutput(BiConsumer<String, PeakAndPlateStatus> writeOutputConsumer,
                             String line,
                             ILicensePlateNumber licensePlateNumber,
                             LocalDate date,
                             LocalTime time,
                             Function<LocalDate, Boolean> isAPeakAndPlateDate,
                             Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        writeOutputConsumer.accept(line, getPeakAndPlateStatus(licensePlateNumber, date, time,
                isAPeakAndPlateDate, isAPeakAndPlateTime));
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

    private PeakAndPlateStatus getPeakAndPlateStatus(ILicensePlateNumber licensePlateNumber,
                                                     LocalDate date,
                                                     LocalTime time,
                                                     Function<LocalDate, Boolean> isAPeakAndPlateDate,
                                                     Function<LocalTime, Boolean> isAPeakAndPlateTime) {
        return licensePlateNumber.peakAndPlateStatusAt(date, time,
                isAPeakAndPlateDate,
                isAPeakAndPlateTime);
    }

    private ILicensePlateNumber takeLicensePlateNumber(Function<String, ILicensePlateNumber> instanceLicensePlateNumber,
                                                       Queue<String> parameters) {
        return instanceLicensePlateNumber.apply(parameters.poll());
    }

    private ArrayDeque<String> getParameters(String line) {
        return new ArrayDeque<>(Arrays.asList(line.split(BLANK_SPACE_STRING)));
    }
}
