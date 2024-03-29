package ec.com.jmgorduez.PeakAndPlatePredictor;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static ec.com.jmgorduez.PeakAndPlatePredictor.PeakAndPlatePredictorApplication.main;
import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.infrastructure.BufferedReaderSupplier.getBufferedReader;
import static ec.com.jmgorduez.PeakAndPlatePredictor.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class PeakAndPlatePredictorApplicationTest {

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
        main(new String[]{INPUT_FILE_PATH});
        assertThat(outContent.toString())
                .isEqualTo(outputMessageForRightInput(PCI_8580_2019_04_15_07_00, NOT_ON_THE_ROAD));
    }

    @Test
    void mainWithArgumentsNonExistingFile() {
        main(new String[]{NON_EXISTING_INPUT_FILE_PATH});
        assertThat(errContent.toString())
                .contains(new FileNotFoundException().getClass().getCanonicalName());
    }

    @Test
    void mainWithoutArguments() {
        simulateUserInput(PCI_8580_2019_04_15_10_00);
        main(new String[]{});
        assertThat(outContent.toString())
                .isEqualTo(initialMessage().concat(
                        outputMessageForRightInput(PCI_8580_2019_04_15_10_00, ON_THE_ROAD)));
    }

    @Test
    void mainUserEntersBlankSpaceStringFollowedByRightInput() {
        simulateUserInput(BLANK_SPACE_STRING.concat(END_OF_LINE)
                .concat(PCI_8580_2019_04_15_10_00).concat(END_OF_LINE));
        main(new String[]{});
        assertThat(outContent.toString())
                .isEqualTo(initialMessage().concat(
                        inputFormatErrorMessage()).concat(
                        outputMessageForRightInput(PCI_8580_2019_04_15_10_00, ON_THE_ROAD)));
        assertThat(errContent.toString())
                .isEqualTo(EMPTY_STRING);
    }

    @Test
    void mainUserEntersAnUnsupportedTimeFormatFollowedByRightInput() {
        simulateUserInput(PCI_8581_2019_04_16_7_00.concat(END_OF_LINE)
                .concat(PCI_8580_2019_04_15_10_00).concat(END_OF_LINE));
        main(new String[]{});
        assertThat(outContent.toString())
                .isEqualTo(initialMessage().concat(
                        inputFormatErrorMessage()).concat(
                        outputMessageForRightInput(PCI_8580_2019_04_15_10_00, ON_THE_ROAD)));
        assertThat(errContent.toString())
                .isEqualTo(EMPTY_STRING);
    }

    private String outputMessageForRightInput(String input, PeakAndPlateStatus output) {
        return input.concat(BLANK_SPACE_STRING).concat(output.name()).concat(END_OF_LINE);
    }

    private String inputFormatErrorMessage() {
        return (INPUT_FORMAT_MESSAGE).concat(END_OF_LINE);
    }

    private String initialMessage() {
        return ENTER_INFORMATION_MESSAGE.concat(END_OF_LINE);
    }
}