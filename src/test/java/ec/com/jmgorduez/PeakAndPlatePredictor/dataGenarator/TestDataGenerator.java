package ec.com.jmgorduez.PeakAndPlatePredictor.dataGenarator;

import ec.com.jmgorduez.PeakAndPlatePredictor.domain.PeakAndPlateRuleUIO;

import java.time.LocalDate;
import java.time.LocalTime;

import static ec.com.jmgorduez.PeakAndPlatePredictor.domain.enums.TypePeakAndPlateRuleUIO.*;

public class TestDataGenerator {

    public static final PeakAndPlateRuleUIO NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_MONDAYS
            = new PeakAndPlateRuleUIO(CAN_BE_NOT_ON_ROAD_ON_MONDAYS);
    public static final PeakAndPlateRuleUIO NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_WEDNESDAYS
            = new PeakAndPlateRuleUIO(CAN_BE_NOT_ON_ROAD_ON_WEDNESDAYS);
    public static final PeakAndPlateRuleUIO NUMBER_UIO_CAN_NOT_ON_THE_ROAD_ON_FRIDAYS
            = new PeakAndPlateRuleUIO(CAN_BE_NOT_ON_ROAD_ON_FRIDAYS);

    public static final String PCI_8580 = "PCI8580";
    public static final String PCI_8581 = "PCI8581";
    public static final String PCI_8584 = "PCI8584";
    public static final String PCI_8585 = "PCI8585";

    public static final LocalDate _01_01_2019 = LocalDate.parse("2019-01-01");
    public static final LocalDate _15_04_2019 = LocalDate.parse("2019-04-15");
    public static final LocalDate _16_04_2019 = LocalDate.parse("2019-04-16");
    public static final LocalDate _19_04_2019 = LocalDate.parse("2019-04-19");
    public static final LocalDate _20_04_2019 = LocalDate.parse("2019-04-20");
    public static final LocalDate _21_04_2019 = LocalDate.parse("2019-04-21");
    public static final LocalDate _24_05_2019 = LocalDate.parse("2019-05-24");
    public static final LocalDate _04_11_2019 = LocalDate.parse("2019-11-04");

    public static final LocalTime _07_00 = LocalTime.parse("07:00");
    public static final LocalTime _08_00 = LocalTime.parse("08:00");
    public static final LocalTime _09_30 = LocalTime.parse("09:30");
    public static final LocalTime _09_31 = LocalTime.parse("09:31");
    public static final LocalTime _16_00 = LocalTime.parse("16:00");
    public static final LocalTime _19_30 = LocalTime.parse("19:30");
    public static final LocalTime _19_31 = LocalTime.parse("19:31");

    public static final String PCI_8580_2019_04_15_07_00 = "PCI8580 2019-04-15 07:00";
    public static final String PCI_8580_2019_04_15_10_00 = "PCI8580 2019-04-15 10:00";
    public static final String PCI_8581_2019_04_16_07_00 = "PCI8581 2019-04-16 07:00";
}
