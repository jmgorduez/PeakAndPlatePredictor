package ec.com.jmgorduez.PeakAndPlatePredictor;


import ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateLineSplitterFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.factories.PeakAndPlateLineLineSplitterFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.factories.IPeakAndPlateRuleFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.factories.PeakAndPlateRuleFactoryUIO;

import java.io.*;
import java.time.format.DateTimeParseException;

import static ec.com.jmgorduez.PeakAndPlatePredictor.infrastructure.BufferedReaderSupplier.doesNotHaveArguments;
import static ec.com.jmgorduez.PeakAndPlatePredictor.infrastructure.BufferedReaderSupplier.getBufferedReader;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.exceptions.ThrowingSupplier.unchecked;

public class PeakAndPlatePredictorApplication {

    private static IPeakAndPlateRuleFactory ruleFactory = new PeakAndPlateRuleFactoryUIO();
    private static IPeakAndPlateLineSplitterFactory splitterFactory = new PeakAndPlateLineLineSplitterFactory();
    private static IPeakAndPlateChecker peakAndPlateChecker = new PeakAndPlateChecker(
            splitterFactory::instanceSplitter, ruleFactory::instanceRule);

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
}
