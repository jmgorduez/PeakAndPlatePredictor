package ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.LicensePlateWithLastNumberZeroOrOne;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.ArgumentMatchers.any;

public class TestDataGenerator {
    public static final LocalDate _15_04_2019 = LocalDate.parse("15/04/2019");

    public static final LocalTime _07_00 = LocalTime.parse("07:00");

    public static final LicensePlateWithLastNumberZeroOrOne PID_8585
            = new LicensePlateWithLastNumberZeroOrOne("PID8585");
    public static final LicensePlateWithLastNumberZeroOrOne PID_8580
            = new LicensePlateWithLastNumberZeroOrOne("PID8580");
}
