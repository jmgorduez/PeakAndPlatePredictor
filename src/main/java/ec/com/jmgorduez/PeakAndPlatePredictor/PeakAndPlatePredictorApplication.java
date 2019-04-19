package ec.com.jmgorduez.PeakAndPlatePredictor;


import ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateLineSplitter;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateStatus;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateChecker;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.abstractions.IPeakAndPlateRuleFactory;
import ec.com.jmgorduez.PeakAndPlatePredictor.domain.uio.PeakAndPlateRuleFactoryUIO;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.ThrowingSupplier.unchecked;

public class PeakAndPlatePredictorApplication {

    private static IPeakAndPlateRuleFactory peakAndPlateRuleFactory = new PeakAndPlateRuleFactoryUIO();
    private static IPeakAndPlateChecker peakAndPlateChecker = getPeakAndPlateChecker();

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
        while (bufferedReader.ready()) {
            try {
                peakAndPlateChecker.checkPeakAndPlate(unchecked(bufferedReader::readLine),
                        PeakAndPlatePredictorApplication::writeOutput);
            } catch (NullPointerException e) {
                System.out.println(INPUT_FORMAT_MESSAGE);
            }
        }
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


    private static PeakAndPlateChecker getPeakAndPlateChecker() {
        return new PeakAndPlateChecker(
                line -> new PeakAndPlateLineSplitter(line, LocalDate::parse, LocalTime::parse),
                peakAndPlateRuleFactory::instanceRule);
    }
}
