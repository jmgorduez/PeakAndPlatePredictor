package ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.LicensePlateNumberUIO;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO.LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_FRIDAYS;
import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.LicensePlateNumberTypeUIO.LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS;

public class TestDataGenerator {

    public static final LicensePlateNumberUIO NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MODAYS
            = new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_MONDAYS);
    public static final LicensePlateNumberUIO NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_FRIDAYS
            = new LicensePlateNumberUIO(LICENSE_PLATE_NUMBER_CAN_BE_NOT_ON_ROAD_ON_FRIDAYS);

    public static final LocalDate _15_04_2019 = LocalDate.parse("2019-04-15");
    public static final LocalDate _16_04_2019 = LocalDate.parse("2019-04-16");
    public static final LocalDate _19_04_2019 = LocalDate.parse("2019-04-19");

    public static final LocalTime _07_00 = LocalTime.parse("07:00");
    public static final LocalTime _08_00 = LocalTime.parse("08:00");
    public static final LocalTime _09_30 = LocalTime.parse("09:30");
    public static final LocalTime _09_31 = LocalTime.parse("09:31");
    public static final LocalTime _16_00 = LocalTime.parse("16:00");
    public static final LocalTime _19_30 = LocalTime.parse("19:30");
    public static final LocalTime _19_31 = LocalTime.parse("19:31");
}
