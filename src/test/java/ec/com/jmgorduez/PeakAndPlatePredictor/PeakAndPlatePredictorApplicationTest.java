package ec.com.jmgorduez.PeakAndPlatePredictor;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlatePredictorApplicationTest {

    private static final String INPUT_FILE_PATH = "/home/jm/projects/java/PeakAndPlatePredictor/inputFile/input.txt";
    private static final String NON_EXISTING_INPUT_FILE_PATH = "/home/jm/projects/java/PeakAndPlatePredictor/inputFile/?????.txt";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void mainWithArguments() {
        PeakAndPlatePredictorApplication.main(new String[]{INPUT_FILE_PATH});
        assertThat(outContent.toString())
                .isEqualTo(PCI_8580_2019_04_15_07_00.concat(BLANK_SPACE_STRING)
                        .concat(PeakAndPlateStatus.NOT_ON_THE_ROAD.name()).concat(END_OF_LINE));
    }

    @Test
    void mainWithArgumentsNonExistingFile() {
        PeakAndPlatePredictorApplication.main(new String[]{NON_EXISTING_INPUT_FILE_PATH});
        assertThat(errContent.toString())
                .contains(new FileNotFoundException().getClass().getCanonicalName());
    }

    @Test
    void mainWithoutArguments() {
        simulateUserInput(PCI_8580_2019_04_15_10_00);
        PeakAndPlatePredictorApplication.main(new String[]{});
        assertThat(outContent.toString())
                .isEqualTo(ENTER_INFORMATION_MESSAGE.concat(END_OF_LINE)
                        .concat(PCI_8580_2019_04_15_10_00).concat(BLANK_SPACE_STRING)
                        .concat(PeakAndPlateStatus.ON_THE_ROAD.name()).concat(END_OF_LINE));
    }

    @Test
    void mainUserEntersBlankSpaceString() {
        simulateUserInput(BLANK_SPACE_STRING);
        PeakAndPlatePredictorApplication.main(new String[]{});
        assertThat(outContent.toString())
                .isEqualTo(INPUT_FORMAT_MESSAGE);
        assertThat(errContent.toString())
                .isEqualTo(EMPTY_STRING);
    }

    @Test
    void getBufferedReaderWithArguments() {
        try {
            String line = PeakAndPlatePredictorApplication.getBufferedReader(new String[]{INPUT_FILE_PATH}).readLine();
            assertThat(line)
                    .isEqualTo(PCI_8580_2019_04_15_07_00);
            simulateUserInput(PCI_8580_2019_04_15_10_00);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getBufferedReaderWithoutArguments() {
        try {
            simulateUserInput(PCI_8580_2019_04_15_10_00);
            String line = PeakAndPlatePredictorApplication.getBufferedReader(new String[]{}).readLine();
            assertThat(line)
                    .isEqualTo(PCI_8580_2019_04_15_10_00);
            simulateUserInput(PCI_8581_2019_04_16_07_00);
            line = PeakAndPlatePredictorApplication.getBufferedReader(new String[]{}).readLine();
            assertThat(line)
                    .isNotEqualTo(PCI_8580_2019_04_15_10_00);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void simulateUserInput(String inputString) {
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(input);
    }
}