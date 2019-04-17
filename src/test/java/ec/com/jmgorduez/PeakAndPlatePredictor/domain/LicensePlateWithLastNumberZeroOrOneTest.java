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

    @Test
    void peakAndPlateStatusAt() {
        licensePlateWithLastNumberZeroOrOneUnderTest = PID_8585;
        assertThat(licensePlateWithLastNumberZeroOrOneUnderTest
                .peakAndPlateStatusAt(_15_04_2019, _07_00, localDate -> true, localTime -> true))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
        licensePlateWithLastNumberZeroOrOneUnderTest = PID_8580;
        assertThat(licensePlateWithLastNumberZeroOrOneUnderTest
                .peakAndPlateStatusAt(_15_04_2019, _07_00, localDate -> true, localTime -> true))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateDate() {
        licensePlateWithLastNumberZeroOrOneUnderTest = PID_8585;
        assertThat(licensePlateWithLastNumberZeroOrOneUnderTest
                .peakAndPlateStatusAt(LocalDate.now(), LocalTime.now(), localDate -> false, localTime -> true))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateTime() {
        licensePlateWithLastNumberZeroOrOneUnderTest = PID_8585;
        assertThat(licensePlateWithLastNumberZeroOrOneUnderTest
                .peakAndPlateStatusAt(LocalDate.now(), LocalTime.now(), localDate -> true, localTime -> false))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }
}