package ec.com.jmgorduez.PeakAndPlatePredictor.infrastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.ZERO;

public class BufferedReaderSupplier {
    public static boolean doesNotHaveArguments(String[] args) {
        return args.length == ZERO;
    }

    public static BufferedReader getBufferedReader(String[] args) throws FileNotFoundException {
        return doesNotHaveArguments(args) ?
                new BufferedReader(new InputStreamReader(System.in)) :
                new BufferedReader(new FileReader(filePath(args)));
    }

    private static String filePath(String[] args) {
        return args[ZERO];
    }
}
