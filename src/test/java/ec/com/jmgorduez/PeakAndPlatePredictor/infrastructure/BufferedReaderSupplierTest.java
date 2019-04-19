package ec.com.jmgorduez.PeakAndPlatePredictor.infrastructure;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.PCI_8580_2019_04_15_10_00;
import static ec.com.jmgorduez.PeakAndPlatePredictor.infrastructure.BufferedReaderSupplier.getBufferedReader;
import static org.assertj.core.api.Assertions.assertThat;

class BufferedReaderSupplierTest {

    @Test
    void getBufferedReaderWithArguments() {
        try {
            String line = getBufferedReader(new String[]{INPUT_FILE_PATH}).readLine();
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
            String line = getBufferedReader(new String[]{}).readLine();
            assertThat(line)
                    .isEqualTo(PCI_8580_2019_04_15_10_00);
            simulateUserInput(PCI_8581_2019_04_16_07_00);
            line = getBufferedReader(new String[]{}).readLine();
            assertThat(line)
                    .isNotEqualTo(PCI_8580_2019_04_15_10_00);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}