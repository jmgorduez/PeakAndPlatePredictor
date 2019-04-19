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
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.ThrowingSupplier.unchecked;

public class PeakAndPlatePredictorApplication {

    private final static String INFORMATION_MESSAGE
            = "Please, enter Lisence plate number date and time following this format XXX0000 YYYY-MM-DD HH:MM or ENTER to exit.";
    private static IPeakAndPlateRuleFactory peakAndPlateRuleFactory = new PeakAndPlateRuleFactoryUIO();
    private static IPeakAndPlateChecker peakAndPlateChecker
            = new PeakAndPlateChecker(line -> new PeakAndPlateLineSplitter(line, LocalDate::parse, LocalTime::parse),
            peakAndPlateRuleFactory::instanceRule);

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader;
            if (args.length != 0) {
                bufferedReader = new BufferedReader(new FileReader(args[0]));
            }else {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println(INFORMATION_MESSAGE);
            }
            peakAndPlateChecker.checkPeakAndPlate(unchecked(bufferedReader::readLine),
                    PeakAndPlatePredictorApplication::writeOutput);
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }

    }

    static void writeOutput(String input, PeakAndPlateStatus peakAndPlateStatus) {
        System.out.println(input.concat(BLANK_SPACE_STRING).concat(peakAndPlateStatus.name()));
    }
}
