package ec.com.jmgorduez.PeakAndPlatePredictor.domain;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator.TestDataGenerator.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO.*;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_NOT_ON_THE_ROAD;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.PeakAndPlateStatus.CAN_BE_ON_THE_ROAD;
import static org.assertj.core.api.Assertions.assertThat;

class LicensePlateNumberUIOTest {

    private LicensePlateNumberUIO licensePlateNumberUIOUnderTest;

    @Test
    void peakAndPlateStatusOnMondays() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_15_04_2019, LocalTime.now(), localDate -> true, localTime -> true))
                .isEqualTo(CAN_BE_NOT_ON_THE_ROAD);
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_16_04_2019, LocalTime.now(), localDate -> true, localTime -> true))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusOnFridays() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_FRIDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_19_04_2019, LocalTime.now(), localDate -> true, localTime -> true))
                .isEqualTo(CAN_BE_NOT_ON_THE_ROAD);
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(_16_04_2019, LocalTime.now(), localDate -> true, localTime -> true))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateDate() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(LocalDate.now(), LocalTime.now(), localDate -> false, localTime -> true))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void peakAndPlateStatusAtNoPeakAndPlateTime() {
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest
                .peakAndPlateStatusAt(LocalDate.now(), LocalTime.now(), localDate -> true, localTime -> false))
                .isEqualTo(CAN_BE_ON_THE_ROAD);
    }

    @Test
    void equals(){
        licensePlateNumberUIOUnderTest = NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS;
        assertThat(licensePlateNumberUIOUnderTest.equals(licensePlateNumberUIOUnderTest))
                .isTrue();
        assertThat(licensePlateNumberUIOUnderTest.equals(this))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest
                .equals(new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_TUESDAYS)))
                .isFalse();
        assertThat(licensePlateNumberUIOUnderTest
                .equals(new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS)))
                .isTrue();
    }
}