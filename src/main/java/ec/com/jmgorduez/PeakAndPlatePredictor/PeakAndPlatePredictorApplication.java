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

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.BLANK_SPACE_STRING;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.INFORMATION_MESSAGE;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.ThrowingSupplier.unchecked;

public class PeakAndPlatePredictorApplication {

    private static IPeakAndPlateRuleFactory peakAndPlateRuleFactory = new PeakAndPlateRuleFactoryUIO();

    public static void main(String[] args) {
        try {
            IPeakAndPlateChecker peakAndPlateChecker = new PeakAndPlateChecker(
                    PeakAndPlatePredictorApplication::getPeakAndPlateLineSplitter,
                    peakAndPlateRuleFactory::instanceRule);
            peakAndPlateChecker.checkPeakAndPlate(unchecked(getBufferedReader(args)::readLine),
                    PeakAndPlatePredictorApplication::writeOutput);
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }

    }

    private static PeakAndPlateLineSplitter getPeakAndPlateLineSplitter(String line) {
        return new PeakAndPlateLineSplitter(line, LocalDate::parse, LocalTime::parse);
    }

    static BufferedReader getBufferedReader(String[] args) throws FileNotFoundException {
        BufferedReader bufferedReader;
        if (hasArguments(args)) {
            bufferedReader = new BufferedReader(new FileReader(args[0]));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(INFORMATION_MESSAGE);
        }
        return bufferedReader;
    }

    private static boolean hasArguments(String[] args) {
        return args.length != 0;
    }

    static void writeOutput(String input, PeakAndPlateStatus peakAndPlateStatus) {
        System.out.println(input.concat(BLANK_SPACE_STRING).concat(peakAndPlateStatus.name()));
    }
}
