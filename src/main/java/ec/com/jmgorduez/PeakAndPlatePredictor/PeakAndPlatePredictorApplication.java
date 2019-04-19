package ec.com.jmgorduez.PeakAndPlatePredictor;


import ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.utils.PeakAndPlateLineSplitter;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateRuleFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.factories.PeakAndPlateRuleFactoryUIO;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.exceptions.ThrowingSupplier.unchecked;

public class PeakAndPlatePredictorApplication {

    private static IPeakAndPlateRuleFactory peakAndPlateRuleFactory = new PeakAndPlateRuleFactoryUIO();
    private static IPeakAndPlateChecker peakAndPlateChecker
            = new PeakAndPlateChecker(
            line -> new PeakAndPlateLineSplitter(line, LocalDate::parse, LocalTime::parse),
            peakAndPlateRuleFactory::instanceRule);

    public static void main(String[] args) {
        try {
            if (doesNotHaveArguments(args)) {
                System.out.println(ENTER_INFORMATION_MESSAGE);
            }
            checkPeakAndPlate(getBufferedReader(args));
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }
    }

    private static void checkPeakAndPlate(BufferedReader bufferedReader) throws IOException {
        do {
            try {
                peakAndPlateChecker.checkPeakAndPlate(unchecked(bufferedReader::readLine),
                        PeakAndPlatePredictorApplication::writeOutput);
                break;
            } catch (NullPointerException | DateTimeParseException e) {
                System.out.println(INPUT_FORMAT_MESSAGE);
                continue;
            }
        } while (true);
    }

    static void writeOutput(String input, PeakAndPlateStatus peakAndPlateStatus) {
        System.out.println(input.concat(BLANK_SPACE_STRING).concat(peakAndPlateStatus.name()));
    }

    private static boolean doesNotHaveArguments(String[] args) {
        return !hasArguments(args);
    }

    private static boolean hasArguments(String[] args) {
        return args.length != 0;
    }

    static BufferedReader getBufferedReader(String[] args) throws FileNotFoundException {
        BufferedReader bufferedReader;
        if (hasArguments(args)) {
            bufferedReader = new BufferedReader(new FileReader(args[ZERO]));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        return bufferedReader;
    }
}
