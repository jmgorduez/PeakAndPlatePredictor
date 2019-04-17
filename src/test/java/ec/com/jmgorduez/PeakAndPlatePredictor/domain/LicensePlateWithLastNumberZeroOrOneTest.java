package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LicensePlateWithLastNumberZeroOrOneTest {

    private LicensePlateWithLastNumberZeroOrOne licensePlateWithLastNumberZeroOrOneUnderTest;

    @BeforeEach
    void setUp(){
        licensePlateWithLastNumberZeroOrOneUnderTest = new LicensePlateWithLastNumberZeroOrOne();
    }

    @Test
    void peakAndPlateStatusAt() {
        assertThat(licensePlateWithLastNumberZeroOrOneUnderTest
                .peakAndPlateStatusAt(_15_04_2019, LocalTime.now(), localDate -> true, localTime -> true))
                .isEqualTo(CAN_BE_NOT_ON_THE_ROAD);
        assertThat(licensePlateWithLastNumberZeroOrOneUnderTest
                .peakAndPlateStatusAt(_16_04_2019, LocalTime.now(), localDate -> true, localTime -> true))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateDate() {
        assertThat(licensePlateWithLastNumberZeroOrOneUnderTest
                .peakAndPlateStatusAt(LocalDate.now(), LocalTime.now(), localDate -> false, localTime -> true))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateTime() {
        assertThat(licensePlateWithLastNumberZeroOrOneUnderTest
                .peakAndPlateStatusAt(LocalDate.now(), LocalTime.now(), localDate -> true, localTime -> false))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }
}